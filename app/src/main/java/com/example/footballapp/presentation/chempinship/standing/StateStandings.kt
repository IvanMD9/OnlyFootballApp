package com.example.footballapp.presentation.chempinship.standing

import com.example.footballapp.data.model.chempionship.standing.StandingsModel

data class StateStandings(
    val standingsInfo: StandingsModel? = null,
    val isLoading : Boolean = false,
    val error : String = ""
)