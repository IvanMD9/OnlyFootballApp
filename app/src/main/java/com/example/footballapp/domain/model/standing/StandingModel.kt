package com.example.footballapp.domain.model.standing

data class StandingModel(
    val group: Any?,
    val stage: String,
    val table: List<TableModel>,
    val type: String
)