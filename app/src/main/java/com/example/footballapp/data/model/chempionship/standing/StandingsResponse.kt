package com.example.footballapp.data.model.chempionship.standing

import com.example.footballapp.data.model.chempionship.matches.AreaResponse
import com.example.footballapp.data.model.chempionship.matches.CompetitionResponse
import com.example.footballapp.data.model.chempionship.matches.FiltersResponse
import com.example.footballapp.data.model.chempionship.matches.SeasonResponse

data class StandingsResponse(
    val area: AreaResponse,
    val competition: CompetitionResponse,
    val filters: FiltersResponse,
    val season: SeasonResponse,
    val standings: List<StandingResponse>
)