package com.example.footballapp.presentation.chempinship.team_matches.world_cup

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.domain.use_case.championship.TeamMatchesUseCase
import com.example.footballapp.presentation.chempinship.team_matches.StateTeamMatches
import com.example.footballapp.utils.Const
import com.example.footballapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TeamMatchesWorldCupViewModel @Inject constructor(
    private val teamMatchesBLUseCase: TeamMatchesUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(StateTeamMatches())
    val state: State<StateTeamMatches> = _state

    init {
        savedStateHandle.get<String>(Const.WC_TEAM_MATCHES)?.let { team_matches ->
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