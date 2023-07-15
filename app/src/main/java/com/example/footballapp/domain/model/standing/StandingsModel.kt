package com.example.footballapp.domain.model.standing

import com.example.footballapp.domain.model.detail_team.AreaModel
import com.example.footballapp.domain.model.matches.CompetitionModel
import com.example.footballapp.domain.model.matches.FiltersModel
import com.example.footballapp.domain.model.matches.SeasonModel

data class StandingsModel(
    val area: AreaModel,
    val competition: CompetitionModel,
    val filters: FiltersModel,
    val season: SeasonModel,
    val standings: List<StandingModel>
)