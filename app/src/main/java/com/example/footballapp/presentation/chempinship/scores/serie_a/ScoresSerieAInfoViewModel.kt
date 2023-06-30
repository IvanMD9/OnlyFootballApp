package com.example.footballapp.presentation.chempinship.scores.serie_a

import com.example.footballapp.data.model.chempionship.scores.ScoresModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.ScoresUseCase
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScoresSerieAInfoViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball
) : BaseViewModel<ScoresModel>(
    useCase = ScoresUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        baseMethod(key = "SA")
    }

    override fun baseMethod(key: String) {
        super.baseMethod(key)
    }
}