package com.example.footballapp.data.repository

import com.example.footballapp.data.model.chempionship.detail_team.TeamDetailModel
import com.example.footballapp.data.model.chempionship.matches.MatchesModel
import com.example.footballapp.data.model.chempionship.matches_team.TeamMatchesModel
import com.example.footballapp.data.model.chempionship.scores.ScoresModel
import com.example.footballapp.data.model.chempionship.standing.StandingsModel
import com.example.footballapp.data.model.chempionship.teams.TeamsModel
import com.example.footballapp.data.remote.FootballApi
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import javax.inject.Inject

class RepositoryChampionshipFootballImpl @Inject constructor(
    private val api: FootballApi
) : RepositoryChampionshipFootball {

    override suspend fun standingsInfo(league : String): StandingsModel {
        return api.standingsInfo(league)
    }

    override suspend fun scoresInfo(scores : String): ScoresModel {
        return api.scoresInfo(scores)
    }

    override suspend fun matchesInfo(matches : String): MatchesModel {
        return api.matchesInfo(matches)
    }

    override suspend fun teamsInfo(teams : String): TeamsModel {
        return api.teamsInfo(teams)
    }

    override suspend fun teamDetailInfo(detail: String): TeamDetailModel {
        return api.teamDetailInfo(detail)
    }

    override suspend fun teamMatchesInfo(teamMatches: String): TeamMatchesModel {
        return api.teamMatchesInfo(teamMatches)
    }
}