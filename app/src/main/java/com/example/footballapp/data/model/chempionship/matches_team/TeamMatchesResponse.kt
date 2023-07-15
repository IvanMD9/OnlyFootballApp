package com.example.footballapp.data.model.chempionship.matches_team

import com.example.footballapp.data.model.chempionship.matches.MatchesResponse

data class TeamMatchesResponse(
    val filters: FiltersTeamMatchesResponse,
    val matches: List<MatchesResponse>,
    val resultSet: ResultSetTeamMatchesResponse
)