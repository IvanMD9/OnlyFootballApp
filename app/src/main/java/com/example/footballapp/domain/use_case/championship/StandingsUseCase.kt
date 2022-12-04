package com.example.footballapp.domain.use_case.championship

import com.example.footballapp.data.model.chempionship.standing.StandingsModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class StandingsUseCase @Inject constructor(
    private val repositoryFootball: RepositoryChampionshipFootball
) {

    operator fun invoke(league : String) : Flow<Resource<StandingsModel>> = flow {
        try {
            emit(Resource.Loading())
            val standingBL = repositoryFootball.standingsInfo(league)
            emit(Resource.Success(standingBL))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error"))
        } catch (e : IOException) {
            emit(Resource.Error("Check you connection Internet"))
        }
    }
}