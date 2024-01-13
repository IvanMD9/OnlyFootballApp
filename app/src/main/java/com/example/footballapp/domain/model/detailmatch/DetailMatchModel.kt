package com.example.footballapp.domain.model.detailmatch

import com.example.footballapp.domain.model.detail_team.AreaModel
import com.example.footballapp.domain.model.matches.CompetitionModel
import com.example.footballapp.domain.model.matches.RefereeModel

data class DetailMatchModel(
    val area: AreaModel,
    val attendance: Int,
    val awayTeam: AwayTeamModel,
    val bookings: List<BookingModel>,
    val competition: CompetitionModel,
    val goals: List<GoalModel>,
    val group: Any?,
    val homeTeam: HomeTeamModel,
    val id: Int,
    val injuryTime: Int,
    val lastUpdated: String,
    val matchday: Int,
    val minute: Int,
    val odds: OddsModelDetail,
    val penalties: List<Any>,
    val referees: List<RefereeModel>,
    val score: ScoreResultModel,
    val season: SeasonModelDetail,
    val stage: String,
    val status: String,
    val substitutions: List<SubstitutionModel>,
    val utcDate: String,
    val venue: String
)