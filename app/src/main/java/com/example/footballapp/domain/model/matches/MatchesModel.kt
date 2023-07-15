package com.example.footballapp.domain.model.matches

data class MatchesModel(
    val competition: CompetitionModel,
    val filters: FiltersModel,
    val matches: List<Matches>,
    val resultSet: ResultSetModel
)