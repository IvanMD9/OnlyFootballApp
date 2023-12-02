package com.example.footballapp.presentation.chempinship.team_matches.world_cup

import androidx.lifecycle.SavedStateHandle
import com.example.footballapp.domain.model.team_matches.TeamMatchesModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.TeamMatchesUseCase
import com.example.footballapp.utils.Const
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamMatchesWorldCupViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<TeamMatchesModel>(
    useCase = TeamMatchesUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        savedStateHandle.get<String>(Const.WC_TEAM_MATCHES)?.let { detailId ->
            baseMethod(detailId)
        }
    }
}