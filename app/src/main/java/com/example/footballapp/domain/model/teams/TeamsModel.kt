package com.example.footballapp.domain.model.teams

import com.example.footballapp.domain.model.detail_team.TeamDetailModel
import com.example.footballapp.domain.model.matches.CompetitionModel
import com.example.footballapp.domain.model.matches.FiltersModel
import com.example.footballapp.domain.model.matches.SeasonModel

data class TeamsModel(
    val competition: CompetitionModel,
    val count: Int,
    val filters: FiltersModel,
    val season: SeasonModel,
    val teams: List<TeamDetailModel>
)