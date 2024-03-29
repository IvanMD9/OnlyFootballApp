package com.example.footballapp.domain.model.matches

import com.example.footballapp.domain.model.detail_team.AreaModel
import kotlinx.collections.immutable.ImmutableList

data class Matches(
    val area: AreaModel,
    val awayTeam: TeamModel,
    val competition: CompetitionModel,
    val group: String?,
    val homeTeam: TeamModel,
    val id: Int,
    val lastUpdated: String,
    val matchday: Int,
    val odds: OddsModel,
    val referees: ImmutableList<RefereeModel>,
    val score: ScoreModel,
    val season: SeasonModel,
    val stage: String,
    val status: String,
    val utcDate: String
)