package com.example.footballapp.data.remote

import com.example.footballapp.data.model.chempionship.detail_team.TeamDetailModel
import com.example.footballapp.data.model.chempionship.matches.MatchesModel
import com.example.footballapp.data.model.chempionship.matches_team.TeamMatchesModel
import com.example.footballapp.data.model.chempionship.scores.ScoresModel
import com.example.footballapp.data.model.chempionship.standing.StandingsModel
import com.example.footballapp.data.model.chempionship.teams.TeamsModel
import com.example.footballapp.data.model.europe.EuropeStandingModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface FootballApi {

    @Headers("X-Auth-Token: $API_KEY")
    @GET("competitions/{league}/standings")
    suspend fun standingsInfo(
        @Path("league") league : String
    ) : StandingsModel

    @Headers("X-Auth-Token: $API_KEY")
    @GET("competitions/{europe}/standings")
    suspend fun standingsEuropeInfo(
        @Path("europe") europe : String
    ) : EuropeStandingModel

    @Headers("X-Auth-Token: $API_KEY")
    @GET("competitions/{scores}/scorers")
    suspend fun scoresInfo(
        @Path("scores") scores : String
    ) : ScoresModel

    @Headers("X-Auth-Token: $API_KEY")
    @GET("competitions/{matches}/matches")
    suspend fun matchesInfo(
        @Path("matches") matches : String
    ) : MatchesModel

    @Headers("X-Auth-Token: $API_KEY")
    @GET("competitions/{teams}/teams")
    suspend fun teamsInfo(
        @Path("teams") teams : String
    ) : TeamsModel

    @Headers("X-Auth-Token: $API_KEY")
    @GET("teams/{detail_team}")
    suspend fun teamDetailInfo(
        @Path("detail_team") detail : String
    ) : TeamDetailModel

    @Headers("X-Auth-Token: $API_KEY")
    @GET("teams/{team_matches}/matches")
    suspend fun teamMatchesInfo(
        @Path("team_matches") teamMatches : String
    ) : TeamMatchesModel

    companion object {
        const val BASE_URL = "http://api.football-data.org/v4/"
        const val API_KEY = "148d6e35f35240a886072de28eccb7dc"
    }
}