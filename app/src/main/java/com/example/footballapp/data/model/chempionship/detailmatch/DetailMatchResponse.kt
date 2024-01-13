package com.example.footballapp.data.model.chempionship.detailmatch

import com.example.footballapp.data.model.chempionship.matches.AreaResponse
import com.example.footballapp.data.model.chempionship.matches.CompetitionResponse
import com.example.footballapp.data.model.chempionship.matches.RefereeResponse

data class DetailMatchResponse(
    val area: AreaResponse,
    val attendance: Int,
    val awayTeam: AwayTeam,
    val bookings: List<Booking>,
    val competition: CompetitionResponse,
    val goals: List<Goal>,
    val group: Any,
    val homeTeam: HomeTeam,
    val id: Int,
    val injuryTime: Int,
    val lastUpdated: String,
    val matchday: Int,
    val minute: Int,
    val odds: Odds,
    val penalties: List<Any>,
    val referees: List<RefereeResponse>,
    val score: ScoreResult,
    val season: Season,
    val stage: String,
    val status: String,
    val substitutions: List<Substitution>,
    val utcDate: String,
    val venue: String
)