package com.example.footballapp.data.model.chempionship.matches_team

data class Matches(
    val area: Area,
    val awayTeam: AwayTeam,
    val competition: Competition,
    val group: String,
    val homeTeam: HomeTeam,
    val id: Int,
    val lastUpdated: String,
    val matchday: Int,
    val odds: Odds,
    val referees: List<Referee>,
    val score: Score,
    val season: Season,
    val stage: String,
    val status: String,
    val utcDate: String
)