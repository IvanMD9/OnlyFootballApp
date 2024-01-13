package com.example.footballapp.domain.use_case.championship

import com.example.footballapp.domain.model.detailmatch.DetailMatchModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import javax.inject.Inject

class MatchDetailUseCase @Inject constructor(
    private val repositoryFootball: RepositoryChampionshipFootball
) {

     suspend operator fun invoke(id : String) : DetailMatchModel {
        return repositoryFootball.matchDetail(id)
    }
}