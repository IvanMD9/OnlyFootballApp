package com.example.footballapp.domain.model.scorers

import androidx.compose.runtime.Stable
import com.example.footballapp.domain.model.matches.CompetitionModel
import com.example.footballapp.domain.model.matches.SeasonModel
import kotlinx.collections.immutable.ImmutableList

@Stable
data class ScorersModel(
    val competition: CompetitionModel,
    val count: Int,
    val filters: FiltersScorersModel,
    val scorers: ImmutableList<ScorerModel>,
    val season: SeasonModel
)