package com.example.footballapp.data.model.chempionship.detail_team

import com.fasterxml.jackson.annotation.JsonProperty

data class RunningCompetitionResponse(
    @JsonProperty("code")
    val code: String,
    @JsonProperty("emblem")
    val emblem: String?,
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("type")
    val type: String
)