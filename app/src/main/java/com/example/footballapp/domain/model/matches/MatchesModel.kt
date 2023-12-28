package com.example.footballapp.domain.model.matches

import androidx.compose.runtime.Stable
import kotlinx.collections.immutable.ImmutableList

@Stable
data class MatchesModel(
    val competition: CompetitionModel,
    val filters: FiltersModel,
    val matches: ImmutableList<Matches>,
    val resultSet: ResultSetModel
)