package com.example.footballapp.presentation.chempinship.scores.premier_league

import com.example.footballapp.data.model.chempionship.scores.ScoresModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.ScoresUseCase
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScoresPremierLeagueInfoViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball
) : BaseViewModel<ScoresModel>(
    useCase = ScoresUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        baseMethod(key = "PL")
    }

    override fun baseMethod(key: String) {
        super.baseMethod(key)
    }
}