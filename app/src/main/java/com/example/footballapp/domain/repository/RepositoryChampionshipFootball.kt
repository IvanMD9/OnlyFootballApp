package com.example.footballapp.domain.repository

import com.example.footballapp.data.model.chempionship.teams.TeamsModel
import com.example.footballapp.domain.model.detail_team.TeamDetailModel
import com.example.footballapp.domain.model.matches.MatchesModel
import com.example.footballapp.domain.model.scorers.ScorersModel
import com.example.footballapp.domain.model.standing.StandingsModel
import com.example.footballapp.domain.model.team_matches.TeamMatchesModel

interface RepositoryChampionshipFootball {

    suspend fun standingsInfo(league : String) : StandingsModel
    suspend fun scoresInfo(scores : String) : ScorersModel
    suspend fun matchesInfo(matches : String) : MatchesModel
    suspend fun teamsInfo(teams : String) : TeamsModel
    suspend fun teamDetailInfo(detail : String) : TeamDetailModel
    suspend fun teamMatchesInfo(teamMatches : String) : TeamMatchesModel
}