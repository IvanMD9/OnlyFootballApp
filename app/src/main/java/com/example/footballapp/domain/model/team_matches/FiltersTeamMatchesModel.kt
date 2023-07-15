package com.example.footballapp.domain.model.team_matches

data class FiltersTeamMatchesModel(
    val competitions: String,
    val limit: Int,
    val permission: String
)