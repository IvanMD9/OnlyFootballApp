package com.example.footballapp.data.model.chempionship.detail_team

import com.fasterxml.jackson.annotation.JsonProperty

data class CoachResponse(
    @JsonProperty("contract")
    val contract: ContractResponse?,
    @JsonProperty("dateOfBirth")
    val dateOfBirth: String,
    @JsonProperty("firstName")
    val firstName: String,
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("lastName")
    val lastName: String,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("nationality")
    val nationality: String
)