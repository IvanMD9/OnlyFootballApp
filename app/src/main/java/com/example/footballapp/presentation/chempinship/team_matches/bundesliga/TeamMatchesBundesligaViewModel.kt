package com.example.footballapp.presentation.chempinship.team_matches.bundesliga

import androidx.lifecycle.SavedStateHandle
import com.example.footballapp.data.model.chempionship.matches_team.TeamMatchesModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.use_case.championship.TeamMatchesUseCase
import com.example.footballapp.utils.Const
import com.example.footballapp.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamMatchesBundesligaViewModel @Inject constructor(
    repositoryFootball: RepositoryChampionshipFootball,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<TeamMatchesModel>(
    useCase = TeamMatchesUseCase(repositoryFootball = repositoryFootball)
) {

    init {
        savedStateHandle.get<String>(Const.BUNDESLIGA_TEAM_MATCHES)?.let { detailId ->
            baseMethod(detailId)
        }
    }

    override fun baseMethod(key: String) {
        super.baseMethod(key)
    }
}