package com.example.footballapp.data.model.chempionship.detailmatch

import com.example.footballapp.data.model.chempionship.matches.FullTimeResponse
import com.example.footballapp.data.model.chempionship.matches.HalfTimeResponse

data class ScoreResult(
    val duration: String,
    val fullTime: FullTimeResponse,
    val halfTime: HalfTimeResponse,
    val winner: String
)