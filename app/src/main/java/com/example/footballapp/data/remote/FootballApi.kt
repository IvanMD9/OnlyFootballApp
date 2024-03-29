package com.example.footballapp.data.remote

import com.example.footballapp.data.model.chempionship.detail_team.DetailTeamResponse
import com.example.footballapp.data.model.chempionship.detailmatch.DetailMatchResponse
import com.example.footballapp.data.model.chempionship.matches.MatchesModelResponse
import com.example.footballapp.data.model.chempionship.matches_team.TeamMatchesResponse
import com.example.footballapp.data.model.chempionship.scores.ScorersResponse
import com.example.footballapp.data.model.chempionship.standing.StandingsResponse
import com.example.footballapp.data.model.chempionship.teams.TeamsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface FootballApi {

    @GET("competitions/{league}/standings")
    suspend fun standingsInfo(
        @Path("league") league : String
    ) : StandingsResponse

    @GET("competitions/{europe}/standings")
    suspend fun standingsEuropeInfo(
        @Path("europe") europe : String
    ) : StandingsResponse

    @GET("competitions/{scores}/scorers")
    suspend fun scoresInfo(
        @Path("scores") scores : String
    ) : ScorersResponse

    @GET("competitions/{matches}/matches")
    suspend fun matchesInfo(
        @Path("matches") matches : String
    ) : MatchesModelResponse

    @GET("competitions/{teams}/teams")
    suspend fun teamsInfo(
        @Path("teams") teams : String
    ) : TeamsResponse

    @GET("teams/{detail_team}")
    suspend fun teamDetailInfo(
        @Path("detail_team") detail : String
    ) : DetailTeamResponse

    @GET("teams/{team_matches}/matches")
    suspend fun teamMatchesInfo(
        @Path("team_matches") teamMatches : String
    ) : TeamMatchesResponse

    @GET("matches/{id}")
    suspend fun matchDetail(
        @Path("id") id : String
    ) : DetailMatchResponse

    companion object {
        const val BASE_URL = "http://api.football-data.org/v4/"
    }
}