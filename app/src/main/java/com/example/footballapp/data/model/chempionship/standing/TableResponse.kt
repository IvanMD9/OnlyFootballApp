package com.example.footballapp.data.model.chempionship.standing

import com.example.footballapp.data.model.chempionship.matches.HomeTeamResponse

data class TableResponse(
    val draw: Int,
    val form: String?,
    val goalDifference: Int,
    val goalsAgainst: Int,
    val goalsFor: Int,
    val lost: Int,
    val playedGames: Int,
    val points: Int,
    val position: Int,
    val team: HomeTeamResponse,
    val won: Int
)