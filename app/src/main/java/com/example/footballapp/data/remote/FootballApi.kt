package com.example.footballapp.data.remote

import com.example.footballapp.data.model.chempionship.detail_team.DetailTeamResponse
import com.example.footballapp.data.model.chempionship.matches.MatchesModelResponse
import com.example.footballapp.data.model.chempionship.matches_team.TeamMatchesModel
import com.example.footballapp.data.model.chempionship.scores.ScoresModel
import com.example.footballapp.data.model.chempionship.standing.StandingsModel
import com.example.footballapp.data.model.chempionship.teams.TeamsModel
import retrofit2.http.GET
import retrofit2.http.Path

interface FootballApi {

    @GET("competitions/{league}/standings")
    suspend fun standingsInfo(
        @Path("league") league : String
    ) : StandingsModel

    @GET("competitions/{europe}/standings")
    suspend fun standingsEuropeInfo(
        @Path("europe") europe : String
    ) : StandingsModel

    @GET("competitions/{scores}/scorers")
    suspend fun scoresInfo(
        @Path("scores") scores : String
    ) : ScoresModel

    @GET("competitions/{matches}/matches")
    suspend fun matchesInfo(
        @Path("matches") matches : String
    ) : MatchesModelResponse

    @GET("competitions/{teams}/teams")
    suspend fun teamsInfo(
        @Path("teams") teams : String
    ) : TeamsModel

    @GET("teams/{detail_team}")
    suspend fun teamDetailInfo(
        @Path("detail_team") detail : String
    ) : DetailTeamResponse

    @GET("teams/{team_matches}/matches")
    suspend fun teamMatchesInfo(
        @Path("team_matches") teamMatches : String
    ) : TeamMatchesModel

    companion object {
        const val BASE_URL = "http://api.football-data.org/v4/"
    }
}