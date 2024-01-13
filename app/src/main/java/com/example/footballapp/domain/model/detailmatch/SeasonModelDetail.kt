package com.example.footballapp.domain.model.detailmatch

data class SeasonModelDetail(
    val currentMatchday: Int,
    val endDate: String,
    val id: Int,
    val stages: List<String>,
    val startDate: String,
    val winner: Any
)