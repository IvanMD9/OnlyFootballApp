package com.example.footballapp.data.model.chempionship.detail_team

data class TeamDetailModel(
    val address: String,
    val area: Area,
    val clubColors: String,
    val coach: Coach,
    val crest: String,
    val founded: Int,
    val id: Int,
    val lastUpdated: String,
    val name: String,
    val runningCompetitions: List<RunningCompetition>,
    val shortName: String,
    val squad: List<Squad>,
    val staff: List<Any>,
    val tla: String,
    val venue: String,
    val website: String
)