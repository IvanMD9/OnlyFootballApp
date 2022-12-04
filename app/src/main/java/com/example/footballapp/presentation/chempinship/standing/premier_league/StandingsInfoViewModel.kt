package com.example.footballapp.presentation.chempinship.standing.premier_league

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.domain.use_case.championship.StandingsUseCase
import com.example.footballapp.presentation.chempinship.standing.StateStandings
import com.example.footballapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StandingsPremierLeagueInfoViewModel @Inject constructor(
    private val standingsUseCase: StandingsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(StateStandings())
    val state: State<StateStandings> = _state

    init {
        getStandingsInfo("PL")
    }

    private fun getStandingsInfo(league : String) {
        standingsUseCase.invoke(league).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = StateStandings(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = StateStandings(standingsInfo = result.data)
                }
                is Resource.Error -> {
                    _state.value = StateStandings(error = result.message ?: "An unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }
}