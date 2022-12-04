package com.example.footballapp.domain.use_case.championship

import com.example.footballapp.data.model.chempionship.detail_team.TeamDetailModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TeamDetailUseCase @Inject constructor(
    private val repositoryFootball: RepositoryChampionshipFootball
) {

    operator fun invoke(detail : String) : Flow<Resource<TeamDetailModel>> = flow {
        try {
            emit(Resource.Loading())
            val teamDetailBL = repositoryFootball.teamDetailInfo(detail)
            emit(Resource.Success(teamDetailBL))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error"))
        } catch (e : IOException) {
            emit(Resource.Error("Check you connection Internet"))
        }
    }
}