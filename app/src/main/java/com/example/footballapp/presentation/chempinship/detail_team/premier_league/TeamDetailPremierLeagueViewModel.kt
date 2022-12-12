package com.example.footballapp.presentation.chempinship.detail_team.premier_league

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.domain.use_case.championship.TeamDetailUseCase
import com.example.footballapp.presentation.chempinship.detail_team.StateTeamDetail
import com.example.footballapp.utils.Const
import com.example.footballapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TeamDetailPremierLeagueViewModel @Inject constructor(
    private val teamDetailBLUseCase: TeamDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(StateTeamDetail())
    val state: State<StateTeamDetail> = _state

    init {
        savedStateHandle.get<String>(Const.PREMIER_LEAGUE_DETAIL)?.let { detailId ->
            getTeamDetailInfo(detailId)
        }
    }

    private fun getTeamDetailInfo(detail: String) {
        teamDetailBLUseCase.invoke(detail).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = StateTeamDetail(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = StateTeamDetail(teamDetailInfo = result.data)
                }
                is Resource.Error -> {
                    _state.value = StateTeamDetail(error = result.message ?: "An unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }
}