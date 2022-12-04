package com.example.footballapp.data.model.chempionship.scores

data class Scorer(
    val assists: Int,
    val goals: Int,
    val penalties: Int,
    val player: Player,
    val team: Team
)