package com.example.footballapp.domain.model.teams

import androidx.compose.runtime.Stable
import com.example.footballapp.domain.model.detail_team.TeamDetailModel
import com.example.footballapp.domain.model.matches.CompetitionModel
import com.example.footballapp.domain.model.matches.FiltersModel
import com.example.footballapp.domain.model.matches.SeasonModel
import kotlinx.collections.immutable.ImmutableList

@Stable
data class TeamsModel(
    val competition: CompetitionModel,
    val count: Int,
    val filters: FiltersModel,
    val season: SeasonModel,
    val teams: ImmutableList<TeamDetailModel>
)