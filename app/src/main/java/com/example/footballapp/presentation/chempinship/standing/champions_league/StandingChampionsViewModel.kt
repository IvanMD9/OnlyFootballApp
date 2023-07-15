package com.example.footballapp.presentation.chempinship.standing.champions_league

import com.example.footballapp.domain.model.standing.StandingsModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.StandingsUseCase
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StandingChampionsViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball
) : BaseViewModel<StandingsModel>(
    useCase = StandingsUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        baseMethod(key = "CL")
    }

    override fun baseMethod(key: String) {
        super.baseMethod(key)
    }
}