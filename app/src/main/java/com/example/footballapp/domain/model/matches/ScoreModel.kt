package com.example.footballapp.domain.model.matches

data class ScoreModel(
    val duration: String,
    val extraTime: TimeModel?,
    val fullTime: TimeModel,
    val halfTime: TimeModel,
    val penalties: TimeModel?,
    val regularTime: TimeModel?,
    val winner: String
)