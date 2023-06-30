package com.example.footballapp.domain.use_case.europe

import com.example.footballapp.data.model.chempionship.standing.StandingsModel
import com.example.footballapp.domain.repository.RepositoryEuropeFootball
import com.example.footballapp.utils.Resource
import com.example.footballapp.utils.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class StandingsEuropeUseCase @Inject constructor(
    private val repositoryFootball: RepositoryEuropeFootball
) : BaseUseCase<StandingsModel> {

    override operator fun invoke(param: String): Flow<Resource<StandingsModel>> = flow {
        try {
            emit(Resource.Loading())
            val standingEurope = repositoryFootball.standingsEuropeInfo(param)
            emit(Resource.Success(standingEurope))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error"))
        } catch (e: IOException) {
            emit(Resource.Error("Check you connection Internet"))
        }
    }
}