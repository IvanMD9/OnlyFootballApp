package com.example.footballapp.presentation.chempinship.team_matches

import com.example.footballapp.data.model.chempionship.matches_team.TeamMatchesModel

data class StateTeamMatches(
    val teamMatchesInfo: TeamMatchesModel? = null,
    val isLoading : Boolean = false,
    val error : String = ""
)