package com.example.footballapp.data.model.chempionship.standing

data class StandingResponse(
    val group: Any?,
    val stage: String,
    val table: List<TableResponse>,
    val type: String
)