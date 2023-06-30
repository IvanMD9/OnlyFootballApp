package com.example.footballapp.presentation.chempinship.standing.ligue_1

import com.example.footballapp.data.model.chempionship.standing.StandingsModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.StandingsUseCase
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StandingsLigue1InfoViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball
) : BaseViewModel<StandingsModel>(
    useCase = StandingsUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        baseMethod(key = "FL1")
    }

    override fun baseMethod(key: String) {
        super.baseMethod(key)
    }
}