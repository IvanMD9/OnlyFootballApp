package com.example.footballapp.presentation.chempinship.scores.la_liga

import com.example.footballapp.domain.model.scorers.ScorersModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.ScoresUseCase
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScoresLaLigaInfoViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball
) : BaseViewModel<ScorersModel>(
    useCase = ScoresUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        baseMethod(key = "PD")
    }
}