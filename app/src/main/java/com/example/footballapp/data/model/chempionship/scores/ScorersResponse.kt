package com.example.footballapp.data.model.chempionship.scores

import com.example.footballapp.data.model.chempionship.matches.CompetitionResponse
import com.example.footballapp.data.model.chempionship.matches.SeasonResponse

data class ScorersResponse(
    val competition: CompetitionResponse,
    val count: Int,
    val filters: FiltersScorersResponse,
    val scorers: List<ScorerResponse>,
    val season: SeasonResponse
)