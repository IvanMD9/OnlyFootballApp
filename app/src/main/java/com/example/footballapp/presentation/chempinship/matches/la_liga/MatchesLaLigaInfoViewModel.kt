package com.example.footballapp.presentation.chempinship.matches.la_liga

import com.example.footballapp.domain.model.matches.MatchesModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.MatchDetailUseCase
import com.example.footballapp.domain.use_case.championship.MatchesUseCase
import com.example.footballapp.utils.base.BaseMatchesViewModel
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchesLaLigaInfoViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball
) : BaseMatchesViewModel(
    useCase = MatchesUseCase(repositoryFootball = repositoryFootball),
    detailUseCase = MatchDetailUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        baseMethod(key = "PD")
    }
}