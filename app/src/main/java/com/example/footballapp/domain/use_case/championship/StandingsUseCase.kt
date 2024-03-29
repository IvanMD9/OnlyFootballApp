package com.example.footballapp.domain.use_case.championship

import com.example.footballapp.domain.model.standing.StandingsModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.utils.Resource
import com.example.footballapp.utils.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class StandingsUseCase @Inject constructor(
    private val repositoryFootball: RepositoryChampionshipFootball
) : BaseUseCase<StandingsModel> {

    override operator fun invoke(param : String) : Flow<Resource<StandingsModel>> = flow {
        try {
            emit(Resource.Loading())
            val standingBL = repositoryFootball.standingsInfo(param)
            emit(Resource.Success(standingBL))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error"))
        } catch (e : IOException) {
            emit(Resource.Error("Check you connection Internet"))
        }
    }
}