package com.example.footballapp.utils.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

open class BaseViewModel<Model>(
    val useCase : BaseUseCase<Model>
) : ViewModel() {

    private val _state = MutableStateFlow(BaseState<Model>())
    val state: StateFlow<BaseState<Model>> = _state

    open fun baseMethod(key: String) {
        useCase(key).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = BaseState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = BaseState(data = result.data)
                }
                is Resource.Error -> {
                    _state.value = BaseState(error = result.message ?: "An unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }
}