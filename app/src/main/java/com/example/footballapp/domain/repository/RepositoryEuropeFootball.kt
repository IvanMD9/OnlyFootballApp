package com.example.footballapp.domain.repository

import com.example.footballapp.data.model.chempionship.standing.StandingsModel

interface RepositoryEuropeFootball {

    suspend fun standingsEuropeInfo(europe : String) : StandingsModel
}