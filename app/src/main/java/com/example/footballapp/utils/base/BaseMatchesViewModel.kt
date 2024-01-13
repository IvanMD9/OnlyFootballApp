package com.example.footballapp.utils.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.domain.model.matches.MatchesModel
import com.example.footballapp.domain.use_case.championship.MatchDetailUseCase
import com.example.footballapp.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

open class BaseMatchesViewModel(
    val useCase: BaseUseCase<MatchesModel>,
    val detailUseCase: MatchDetailUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(BaseMatchesState())
    val state = _state.asStateFlow()

    open fun baseMethod(key: String) {
        useCase(key).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = BaseMatchesState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = BaseMatchesState(data = result.data)
                }

                is Resource.Error -> {
                    _state.value = BaseMatchesState(error = result.message ?: "An unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun selectedMatchDialog(id: String) {
        viewModelScope.launch {
            _state.update { match ->
                match.copy(detailMatch = detailUseCase(id))
            }
        }
    }

    fun dismissDialog() {
        viewModelScope.launch {
            _state.update { dismiss ->
                dismiss.copy(detailMatch = null)
            }
        }
    }
}