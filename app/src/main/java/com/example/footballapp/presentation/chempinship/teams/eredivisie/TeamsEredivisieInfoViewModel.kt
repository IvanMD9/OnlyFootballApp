package com.example.footballapp.presentation.chempinship.teams.eredivisie

import com.example.footballapp.domain.model.teams.TeamsModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.TeamsUseCase
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamsEredivisieInfoViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball
) : BaseViewModel<TeamsModel>(
    useCase = TeamsUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        baseMethod(key = "DED")
    }

    override fun baseMethod(key: String) {
        super.baseMethod(key)
    }
}