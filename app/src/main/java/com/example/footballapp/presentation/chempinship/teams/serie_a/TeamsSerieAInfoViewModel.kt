package com.example.footballapp.presentation.chempinship.teams.serie_a

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.domain.use_case.championship.TeamsUseCase
import com.example.footballapp.presentation.chempinship.teams.StateTeams
import com.example.footballapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TeamsSerieAInfoViewModel @Inject constructor(
    private val teamsBLUseCase: TeamsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(StateTeams())
    val state: State<StateTeams> = _state

    init {
        getTeamsInfo("SA")
    }

    private fun getTeamsInfo(teams : String) {
        teamsBLUseCase.invoke(teams).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = StateTeams(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = StateTeams(teamsInfo = result.data)
                }
                is Resource.Error -> {
                    _state.value = StateTeams(error = result.message ?: "An unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }
}