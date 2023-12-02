package com.example.footballapp.presentation.chempinship.team_matches.serie_a

import androidx.lifecycle.SavedStateHandle
import com.example.footballapp.domain.model.team_matches.TeamMatchesModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.TeamMatchesUseCase
import com.example.footballapp.utils.Const
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamMatchesSerieAViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<TeamMatchesModel>(
    useCase = TeamMatchesUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        savedStateHandle.get<String>(Const.SERIE_A_TEAM_MATCHES)?.let { detailId ->
            baseMethod(detailId)
        }
    }
}