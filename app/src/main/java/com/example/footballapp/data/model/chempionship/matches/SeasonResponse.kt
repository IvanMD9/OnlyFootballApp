package com.example.footballapp.data.model.chempionship.matches

data class SeasonResponse(
    val currentMatchday: Int,
    val endDate: String,
    val id: Int,
    val startDate: String,
    val winner: Any?
)