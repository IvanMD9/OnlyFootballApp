package com.example.footballapp.data.model.chempionship.detail_team

import com.fasterxml.jackson.annotation.JsonProperty

data class ContractResponse(
    @JsonProperty("start")
    val start: Any,
    @JsonProperty("until")
    val until: Any
)