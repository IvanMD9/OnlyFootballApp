package com.example.footballapp.presentation.chempinship.standing

import com.example.footballapp.data.model.europe.EuropeStandingModel

data class StateEuropeStanding(
    val europeStanding : EuropeStandingModel? = null,
    val isLoading : Boolean = false,
    val error : String = ""
)
