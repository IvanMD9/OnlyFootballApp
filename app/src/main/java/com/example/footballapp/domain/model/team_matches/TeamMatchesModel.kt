package com.example.footballapp.domain.model.team_matches

import com.example.footballapp.domain.model.matches.Matches

data class TeamMatchesModel(
    val filters: FiltersTeamMatchesModel,
    val matches: List<Matches>,
    val resultSet: ResultSetTeamMatchesModel
)
