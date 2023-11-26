package com.example.footballapp.presentation.chempinship.matches.ligue_1

import com.example.footballapp.domain.model.matches.MatchesModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.MatchesUseCase
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchesLigue1InfoViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball
) : BaseViewModel<MatchesModel>(
    useCase = MatchesUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        baseMethod(key = "FL1")
    }
}