package com.example.footballapp.data.model.chempionship.teams

import com.example.footballapp.data.model.chempionship.detail_team.DetailTeamResponse
import com.example.footballapp.data.model.chempionship.matches.CompetitionResponse
import com.example.footballapp.data.model.chempionship.matches.FiltersResponse
import com.example.footballapp.data.model.chempionship.matches.SeasonResponse

data class TeamsResponse(
    val competition: CompetitionResponse,
    val count: Int,
    val filters: FiltersResponse,
    val season: SeasonResponse,
    val teams: List<DetailTeamResponse>
)