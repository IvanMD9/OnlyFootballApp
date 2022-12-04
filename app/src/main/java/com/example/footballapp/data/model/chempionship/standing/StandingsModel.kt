package com.example.footballapp.data.model.chempionship.standing

data class StandingsModel(
    val area: Area,
    val competition: Competition,
    val filters: Filters,
    val season: Season,
    val standings: List<Standing>
)