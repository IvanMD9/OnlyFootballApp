package com.example.footballapp.data.model.chempionship.matches

data class MatchesResponse(
    val area: AreaResponse,
    val awayTeam: AwayTeamResponse,
    val competition: CompetitionResponse,
    val group: String?,
    val homeTeam: HomeTeamResponse,
    val id: Int,
    val lastUpdated: String,
    val matchday: Int,
    val odds: OddsResponse,
    val referees: List<RefereeResponse>,
    val score: ScoreResponse,
    val season: SeasonResponse,
    val stage: String,
    val status: String,
    val utcDate: String
)