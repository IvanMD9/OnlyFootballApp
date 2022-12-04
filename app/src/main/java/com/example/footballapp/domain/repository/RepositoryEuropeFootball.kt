package com.example.footballapp.domain.repository

import com.example.footballapp.data.model.europe.EuropeStandingModel

interface RepositoryEuropeFootball {

    suspend fun standingsEuropeInfo(europe : String) : EuropeStandingModel
//    suspend fun scoresInfo(scores : String) : ScoresModel
//    suspend fun matchesInfo(matches : String) : MatchesModel
//    suspend fun teamsInfo(teams : String) : TeamsModel
//    suspend fun teamDetailInfo(detail : String) : TeamDetailModel
//    suspend fun teamMatchesInfo(teamMatches : String) : TeamMatchesModel
}