package com.example.footballapp.domain.model.detailmatch

data class BookingModel(
    val card: String,
    val minute: Int,
    val player: PlayerModelDetail,
    val team: TeamModelDetail
)