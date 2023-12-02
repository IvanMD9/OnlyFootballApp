package com.example.footballapp.presentation.chempinship.detail_team.la_liga

import androidx.lifecycle.SavedStateHandle
import com.example.footballapp.domain.model.detail_team.TeamDetailModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.TeamDetailUseCase
import com.example.footballapp.utils.Const
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamDetailLaLigaViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<TeamDetailModel>(
    useCase = TeamDetailUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        savedStateHandle.get<String>(Const.LA_LIGA_DETAIL)?.let { detailId ->
            baseMethod(detailId)
        }
    }
}