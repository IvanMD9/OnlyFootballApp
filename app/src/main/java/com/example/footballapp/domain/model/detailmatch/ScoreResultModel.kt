package com.example.footballapp.domain.model.detailmatch

import com.example.footballapp.domain.model.matches.TimeModel

data class ScoreResultModel(
    val duration: String,
    val fullTime: TimeModel,
    val halfTime: TimeModel,
    val winner: String
)