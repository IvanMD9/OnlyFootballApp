package com.example.footballapp.domain.model.detailmatch

data class HomeTeamModel(
    val bench: List<BenchModel>,
    val coach: CoachModelDetail,
    val crest: String,
    val formation: String,
    val id: Int,
    val leagueRank: Any,
    val lineup: List<LineupModel>,
    val name: String,
    val shortName: String,
    val statistics: StatisticsModel,
    val tla: String
)