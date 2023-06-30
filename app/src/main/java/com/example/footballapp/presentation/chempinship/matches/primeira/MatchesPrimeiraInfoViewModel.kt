package com.example.footballapp.presentation.chempinship.matches.primeira

import com.example.footballapp.data.model.chempionship.matches.MatchesModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.MatchesUseCase
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// TODO: Временное решение с передачей репозиторя в конструктор, так делать нельзя!!!
@HiltViewModel
class MatchesPrimeiraInfoViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball
) : BaseViewModel<MatchesModel>(
    useCase = MatchesUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        baseMethod(key = "PPL")
    }

    override fun baseMethod(key: String) {
        super.baseMethod(key)
    }
}