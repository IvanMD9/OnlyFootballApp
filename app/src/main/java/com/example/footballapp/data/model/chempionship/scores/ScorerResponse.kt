package com.example.footballapp.data.model.chempionship.scores

data class ScorerResponse(
    val assists: Int,
    val goals: Int,
    val penalties: Int,
    val player: PlayerResponse,
    val team: TeamResponse
)