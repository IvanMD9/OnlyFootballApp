package com.example.footballapp.domain.model.scorers

data class ScorerModel(
    val assists: Int,
    val goals: Int,
    val penalties: Int,
    val player: PlayerModel,
    val team: TeamScorersModel
)