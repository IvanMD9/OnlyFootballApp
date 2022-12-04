package com.example.footballapp.data.model.chempionship.matches_team

data class Score(
    val duration: String,
    val fullTime: FullTime,
    val halfTime: HalfTime,
    val winner: String
)