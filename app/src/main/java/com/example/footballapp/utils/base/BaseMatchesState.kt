package com.example.footballapp.utils.base

import com.example.footballapp.domain.model.detailmatch.DetailMatchModel
import com.example.footballapp.domain.model.matches.MatchesModel

data class BaseMatchesState(
    val data: MatchesModel? = null,
    val isLoading : Boolean = false,
    val error : String = "",
    val detailMatch : DetailMatchModel? = null,
)