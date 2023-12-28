package com.example.footballapp.domain.model.detail_team

import androidx.compose.runtime.Stable
import kotlinx.collections.immutable.ImmutableList

@Stable
data class TeamDetailModel(
    val address: String,
    val area: AreaModel,
    val clubColors: String,
    val coach: CoachModel,
    val crest: String,
    val founded: Int,
    val id: Int,
    val lastUpdated: String,
    val name: String,
    val runningCompetitions: ImmutableList<RunningCompetitionModel>,
    val shortName: String,
    val squad: ImmutableList<SquadModel>,
    val staff: ImmutableList<Any>,
    val tla: String,
    val venue: String,
    val website: String
)
