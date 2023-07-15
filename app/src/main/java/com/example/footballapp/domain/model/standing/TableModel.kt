package com.example.footballapp.domain.model.standing

import com.example.footballapp.domain.model.matches.TeamModel

data class TableModel(
    val draw: Int,
    val form: String,
    val goalDifference: Int,
    val goalsAgainst: Int,
    val goalsFor: Int,
    val lost: Int,
    val playedGames: Int,
    val points: Int,
    val position: Int,
    val team: TeamModel,
    val won: Int
)