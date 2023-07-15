package com.example.footballapp.presentation.chempinship.teams.serie_a

import com.example.footballapp.domain.model.teams.TeamsModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.TeamsUseCase
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamsSerieAInfoViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball
) : BaseViewModel<TeamsModel>(
    useCase = TeamsUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        baseMethod(key = "SA")
    }

    override fun baseMethod(key: String) {
        super.baseMethod(key)
    }
}