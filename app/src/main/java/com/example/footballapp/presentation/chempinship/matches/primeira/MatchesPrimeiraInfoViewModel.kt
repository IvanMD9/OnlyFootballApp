package com.example.footballapp.presentation.chempinship.matches.primeira

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.domain.use_case.championship.MatchesUseCase
import com.example.footballapp.presentation.chempinship.matches.StateMatches
import com.example.footballapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MatchesPrimeiraInfoViewModel @Inject constructor(
    private val matchesBLUseCase: MatchesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(StateMatches())
    val state: State<StateMatches> = _state

    init {
        getMatchesInfo("PPL")
    }

    private fun getMatchesInfo(matches : String) {
        matchesBLUseCase.invoke(matches).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = StateMatches(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = StateMatches(matchesInfo = result.data)
                }
                is Resource.Error -> {
                    _state.value = StateMatches(error = result.message ?: "An unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }
}