package com.example.footballapp.presentation.chempinship.teams.ligue_1

import com.example.footballapp.data.model.chempionship.teams.TeamsModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.TeamsUseCase
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamsLigue1InfoViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball
) : BaseViewModel<TeamsModel>(
    useCase = TeamsUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        baseMethod(key = "FL1")
    }

    override fun baseMethod(key: String) {
        super.baseMethod(key)
    }
}