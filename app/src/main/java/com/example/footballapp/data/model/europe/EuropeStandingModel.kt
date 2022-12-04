package com.example.footballapp.data.model.europe

data class EuropeStandingModel(
    val area: Area,
    val competition: Competition,
    val filters: Filters,
    val season: Season,
    val standings: List<Standing>
)