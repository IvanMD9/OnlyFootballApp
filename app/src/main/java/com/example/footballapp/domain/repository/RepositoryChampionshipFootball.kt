package com.example.footballapp.domain.repository

import com.example.footballapp.data.model.chempionship.detail_team.TeamDetailModel
import com.example.footballapp.data.model.chempionship.matches.MatchesModel
import com.example.footballapp.data.model.chempionship.matches_team.TeamMatchesModel
import com.example.footballapp.data.model.chempionship.scores.ScoresModel
import com.example.footballapp.data.model.chempionship.standing.StandingsModel
import com.example.footballapp.data.model.chempionship.teams.TeamsModel

interface RepositoryChampionshipFootball {

    suspend fun standingsInfo(league : String) : StandingsModel
    suspend fun scoresInfo(scores : String) : ScoresModel
    suspend fun matchesInfo(matches : String) : MatchesModel
    suspend fun teamsInfo(teams : String) : TeamsModel
    suspend fun teamDetailInfo(detail : String) : TeamDetailModel
    suspend fun teamMatchesInfo(teamMatches : String) : TeamMatchesModel
}