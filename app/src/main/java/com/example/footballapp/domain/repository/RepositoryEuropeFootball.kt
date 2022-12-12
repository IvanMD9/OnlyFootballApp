package com.example.footballapp.domain.repository

import com.example.footballapp.data.model.europe.EuropeStandingModel

interface RepositoryEuropeFootball {

    suspend fun standingsEuropeInfo(europe : String) : EuropeStandingModel
}