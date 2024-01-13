package com.example.footballapp.data.model.chempionship.detailmatch

data class Season(
    val currentMatchday: Int,
    val endDate: String,
    val id: Int,
    val stages: List<String>?,
    val startDate: String,
    val winner: Any?
)