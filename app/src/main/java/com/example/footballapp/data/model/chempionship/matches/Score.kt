package com.example.footballapp.data.model.chempionship.matches

data class Score(
    val duration: String,
    val extraTime: ExtraTime,
    val fullTime: FullTime,
    val halfTime: HalfTime,
    val penalties: Penalties?,
    val regularTime: RegularTime?,
    val winner: String
)