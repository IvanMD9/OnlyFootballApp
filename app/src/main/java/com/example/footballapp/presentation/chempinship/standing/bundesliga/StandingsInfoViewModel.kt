package com.example.footballapp.presentation.chempinship.standing.bundesliga

import com.example.footballapp.data.model.chempionship.standing.StandingsModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.StandingsUseCase
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StandingsBundesligaInfoViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball
) : BaseViewModel<StandingsModel>(
    useCase = StandingsUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        baseMethod(key = "BL1")
    }

    override fun baseMethod(key: String) {
        super.baseMethod(key)
    }
}