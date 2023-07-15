package com.example.footballapp.data.model.chempionship.matches

data class ScoreResponse(
    val duration: String,
    val extraTime: ExtraTimeResponse?,
    val fullTime: FullTimeResponse,
    val halfTime: HalfTimeResponse,
    val penalties: PenaltiesResponse?,
    val regularTime: RegularTimeResponse?,
    val winner: String?
)