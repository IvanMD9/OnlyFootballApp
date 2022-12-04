package com.example.footballapp.presentation.chempinship.detail_team

import com.example.footballapp.data.model.chempionship.detail_team.TeamDetailModel

data class StateTeamDetail(
    val teamDetailInfo: TeamDetailModel? = null,
    val isLoading : Boolean = false,
    val error : String = ""
)