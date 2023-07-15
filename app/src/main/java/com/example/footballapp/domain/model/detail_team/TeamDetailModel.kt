package com.example.footballapp.domain.model.detail_team

data class TeamDetailModel(
    val address: String,
    val area: AreaModel,
    val clubColors: String,
    val coach: CoachModel,
    val crest: String,
    val founded: Int,
    val id: Int,
    val lastUpdated: String,
    val name: String,
    val runningCompetitions: List<RunningCompetitionModel>,
    val shortName: String,
    val squad: List<SquadModel>,
    val staff: List<Any>,
    val tla: String,
    val venue: String,
    val website: String
)
