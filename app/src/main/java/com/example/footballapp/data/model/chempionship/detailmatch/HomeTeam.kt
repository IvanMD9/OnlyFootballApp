package com.example.footballapp.data.model.chempionship.detailmatch

data class HomeTeam(
    val bench: List<Bench>?,
    val coach: Coach?,
    val crest: String,
    val formation: String?,
    val id: Int,
    val leagueRank: Any?,
    val lineup: List<Lineup>?,
    val name: String,
    val shortName: String,
    val statistics: Statistics?,
    val tla: String
)