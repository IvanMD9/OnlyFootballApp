package com.example.footballapp.data.repository

import com.example.footballapp.data.model.chempionship.standing.StandingsResponse
import com.example.footballapp.data.remote.FootballApi
import com.example.footballapp.domain.repository.RepositoryEuropeFootball
import javax.inject.Inject

class RepositoryEuropeFootballImpl @Inject constructor(
    private val api: FootballApi
) : RepositoryEuropeFootball {

    override suspend fun standingsEuropeInfo(europe: String): StandingsResponse {
        return api.standingsEuropeInfo(europe)
    }
}