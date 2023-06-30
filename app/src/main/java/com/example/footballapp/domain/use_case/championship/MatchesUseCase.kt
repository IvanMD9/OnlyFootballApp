package com.example.footballapp.domain.use_case.championship

import com.example.footballapp.data.model.chempionship.matches.MatchesModel
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.utils.Resource
import com.example.footballapp.utils.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MatchesUseCase @Inject constructor(
    private val repositoryFootball: RepositoryChampionshipFootball
) : BaseUseCase<MatchesModel> {
    override fun invoke(param: String): Flow<Resource<MatchesModel>> = flow {
        try {
            emit(Resource.Loading())
            val matchesBL = repositoryFootball.matchesInfo(param)
            emit(Resource.Success(matchesBL))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error"))
        } catch (e : IOException) {
            emit(Resource.Error("Check you connection Internet"))
        }
    }
}