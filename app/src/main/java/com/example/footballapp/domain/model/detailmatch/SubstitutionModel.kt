package com.example.footballapp.domain.model.detailmatch

data class SubstitutionModel(
    val minute: Int,
    val playerIn: PlayerInModel,
    val playerOut: PlayerOutModel,
    val team: TeamModelDetail
)