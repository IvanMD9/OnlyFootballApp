package com.example.footballapp.domain.model.scorers

import com.example.footballapp.domain.model.matches.CompetitionModel
import com.example.footballapp.domain.model.matches.SeasonModel

data class ScorersModel(
    val competition: CompetitionModel,
    val count: Int,
    val filters: FiltersScorersModel,
    val scorers: List<ScorerModel>,
    val season: SeasonModel
)