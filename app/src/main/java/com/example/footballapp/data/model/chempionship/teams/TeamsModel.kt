package com.example.footballapp.data.model.chempionship.teams

data class TeamsModel(
    val competition: Competition,
    val count: Int,
    val filters: Filters,
    val season: Season,
    val teams: List<Team>
)