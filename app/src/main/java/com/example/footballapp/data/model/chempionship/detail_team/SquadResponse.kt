package com.example.footballapp.data.model.chempionship.detail_team

import com.fasterxml.jackson.annotation.JsonProperty

data class SquadResponse(
    @JsonProperty("dateOfBirth")
    val dateOfBirth: String,
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("nationality")
    val nationality: String,
    @JsonProperty("position")
    val position: String
)