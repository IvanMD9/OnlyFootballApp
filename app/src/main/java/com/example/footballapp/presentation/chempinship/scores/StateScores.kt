package com.example.footballapp.presentation.chempinship.scores

import com.example.footballapp.data.model.chempionship.scores.ScoresModel

data class StateScores(
    val scoresInfo: ScoresModel? = null,
    val isLoading : Boolean = false,
    val error : String = ""
)