package com.example.footballapp.domain.use_case.championship

import com.example.footballapp.domain.model.teams.TeamsModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.utils.Resource
import com.example.footballapp.utils.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TeamsUseCase @Inject constructor(
    private val repositoryFootball: RepositoryChampionshipFootball
) : BaseUseCase<TeamsModel> {

    override operator fun invoke(param : String) : Flow<Resource<TeamsModel>> = flow {
        try {
            emit(Resource.Loading())
            val teamsBL = repositoryFootball.teamsInfo(param)
            emit(Resource.Success(teamsBL))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error"))
        } catch (e : IOException) {
            emit(Resource.Error("Check you connection Internet"))
        }
    }
}