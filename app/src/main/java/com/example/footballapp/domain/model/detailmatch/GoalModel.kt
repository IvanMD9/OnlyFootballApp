package com.example.footballapp.domain.model.detailmatch

data class GoalModel(
    val assist: AssistModel,
    val injuryTime: Any,
    val minute: Int,
    val score: ScoreModelDetail,
    val scorer: ScorerModelDetail,
    val team: TeamModelDetail,
    val type: String
)