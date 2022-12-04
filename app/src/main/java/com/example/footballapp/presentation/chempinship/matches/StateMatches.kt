package com.example.footballapp.presentation.chempinship.matches

import com.example.footballapp.data.model.chempionship.matches.MatchesModel

data class StateMatches(
    val matchesInfo: MatchesModel? = null,
    val isLoading : Boolean = false,
    val error : String = ""
)