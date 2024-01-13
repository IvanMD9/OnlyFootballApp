package com.example.footballapp.data.model.chempionship.detailmatch

data class Goal(
    val assist: Assist,
    val injuryTime: Any?,
    val minute: Int,
    val score: Score,
    val scorer: Scorer,
    val team: Team,
    val type: String
)