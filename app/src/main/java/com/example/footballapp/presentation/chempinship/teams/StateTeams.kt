package com.example.footballapp.presentation.chempinship.teams

import com.example.footballapp.data.model.chempionship.teams.TeamsModel

data class StateTeams(
    val teamsInfo: TeamsModel? = null,
    val isLoading : Boolean = false,
    val error : String = ""
)