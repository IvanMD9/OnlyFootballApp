package com.example.footballapp.data.model.chempionship.detail_team

import com.example.footballapp.data.model.chempionship.matches.AreaResponse
import com.fasterxml.jackson.annotation.JsonProperty

data class DetailTeamResponse(
    @JsonProperty("address")
    val address: String,
    @JsonProperty("area")
    val area: AreaResponse,
    @JsonProperty("clubColors")
    val clubColors: String?,
    @JsonProperty("coach")
    val coach: CoachResponse?,
    @JsonProperty("crest")
    val crest: String,
    @JsonProperty("founded")
    val founded: Int,
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("lastUpdated")
    val lastUpdated: String,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("runningCompetitions")
    val runningCompetitions: List<RunningCompetitionResponse>,
    @JsonProperty("shortName")
    val shortName: String,
    @JsonProperty("squad")
    val squad: List<SquadResponse>,
    @JsonProperty("staff")
    val staff: List<Any>,
    @JsonProperty("tla")
    val tla: String,
    @JsonProperty("venue")
    val venue: String,
    @JsonProperty("website")
    val website: String?
)