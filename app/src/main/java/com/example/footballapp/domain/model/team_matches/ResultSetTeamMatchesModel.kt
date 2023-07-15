package com.example.footballapp.domain.model.team_matches

data class ResultSetTeamMatchesModel(
    val competitions: String,
    val count: Int,
    val draws: Int,
    val first: String,
    val last: String,
    val losses: Int,
    val played: Int,
    val wins: Int
)