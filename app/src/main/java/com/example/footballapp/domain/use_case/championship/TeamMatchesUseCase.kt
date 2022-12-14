package com.example.footballapp.domain.use_case.championship

import com.example.footballapp.data.model.chempionship.matches_team.TeamMatchesModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TeamMatchesUseCase @Inject constructor(
    private val repositoryFootball: RepositoryChampionshipFootball
) {

    operator fun invoke(teamMatches : String) : Flow<Resource<TeamMatchesModel>> = flow {
        try {
            emit(Resource.Loading())
            val teamMatchesBL = repositoryFootball.teamMatchesInfo(teamMatches)
            emit(Resource.Success(teamMatchesBL))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error"))
        } catch (e : IOException) {
            emit(Resource.Error("Check you connection Internet"))
        }
    }
}