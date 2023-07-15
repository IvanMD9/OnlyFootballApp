package com.example.footballapp.data.model.chempionship.matches

data class MatchesModelResponse(
    val competition: CompetitionResponse,
    val filters: FiltersResponse,
    val matches: List<MatchesResponse>,
    val resultSet: ResultSetResponse
)