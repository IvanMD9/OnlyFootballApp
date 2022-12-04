package com.example.footballapp.data.model.chempionship.matches

data class MatchesModel(
    val competition: Competition,
    val filters: Filters,
    val matches: List<Matches>,
    val resultSet: ResultSet
)