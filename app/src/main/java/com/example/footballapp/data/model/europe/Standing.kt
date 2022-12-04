package com.example.footballapp.data.model.europe

data class Standing(
    val group: String,
    val stage: String,
    val table: List<Table>,
    val type: String
)