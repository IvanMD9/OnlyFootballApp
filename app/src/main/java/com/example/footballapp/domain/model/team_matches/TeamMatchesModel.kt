package com.example.footballapp.domain.model.team_matches

import androidx.compose.runtime.Stable
import com.example.footballapp.domain.model.matches.Matches
import kotlinx.collections.immutable.ImmutableList

@Stable
data class TeamMatchesModel(
    val filters: FiltersTeamMatchesModel,
    val matches: ImmutableList<Matches>,
    val resultSet: ResultSetTeamMatchesModel
)
