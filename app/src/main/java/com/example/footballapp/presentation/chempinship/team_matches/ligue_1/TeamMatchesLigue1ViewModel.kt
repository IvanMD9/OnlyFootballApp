package com.example.footballapp.presentation.chempinship.team_matches.ligue_1

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.domain.use_case.championship.TeamMatchesUseCase
import com.example.footballapp.presentation.chempinship.team_matches.StateTeamMatches
import com.example.footballapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TeamMatchesLigue1ViewModel @Inject constructor(
    private val teamMatchesBLUseCase: TeamMatchesUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(StateTeamMatches())
    val state: State<StateTeamMatches> = _state

    init {
        savedStateHandle.get<String>("team_matches_fl1")?.let { team_matches ->
            getTeamMatchesInfo(team_matches)
        }
    }

    private fun getTeamMatchesInfo(teamMatches: String) {
        teamMatchesBLUseCase.invoke(teamMatches).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = StateTeamMatches(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = StateTeamMatches(teamMatchesInfo = result.data)
                }
                is Resource.Error -> {
                    _state.value = StateTeamMatches(error = result.message ?: "An unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }
}