package com.example.footballapp.data.model.chempionship.scores

data class ScoresModel(
    val competition: Competition,
    val count: Int,
    val filters: Filters,
    val scorers: List<Scorer>,
    val season: Season
)