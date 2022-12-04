package com.example.footballapp.data.model.chempionship.matches_team

data class TeamMatchesModel(
    val filters: Filters,
    val matches: List<Matches>,
    val resultSet: ResultSet
)