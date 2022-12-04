package com.example.footballapp.presentation.chempinship.standing.champions_league

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.domain.use_case.europe.StandingsEuropeUseCase
import com.example.footballapp.presentation.chempinship.standing.StateEuropeStanding
import com.example.footballapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StandingChampionsViewModel @Inject constructor(
    private val standingsEuropeUseCase: StandingsEuropeUseCase
) : ViewModel() {

    private val _state = mutableStateOf(StateEuropeStanding())
    val state: State<StateEuropeStanding> = _state

    init {
        getStandingsInfo("CL")
    }

    private fun getStandingsInfo(europe: String) {
        standingsEuropeUseCase.invoke(europe).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = StateEuropeStanding(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = StateEuropeStanding(europeStanding = result.data)
                }
                is Resource.Error -> {
                    _state.value = StateEuropeStanding(error = result.message ?: "An unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }
}