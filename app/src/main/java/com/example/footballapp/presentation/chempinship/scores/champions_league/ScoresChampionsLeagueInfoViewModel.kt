package com.example.footballapp.presentation.chempinship.scores.champions_league

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.domain.use_case.championship.ScoresUseCase
import com.example.footballapp.presentation.chempinship.scores.StateScores
import com.example.footballapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ScoresChampionsLeagueInfoViewModel @Inject constructor(
    private val scoresBLUseCase: ScoresUseCase
) : ViewModel() {

    private val _state = mutableStateOf(StateScores())
    val state: State<StateScores> = _state

    init {
        getScoresInfo("CL")
    }

    private fun getScoresInfo(scores : String) {
        scoresBLUseCase.invoke(scores).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = StateScores(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = StateScores(scoresInfo = result.data)
                }
                is Resource.Error -> {
                    _state.value = StateScores(error = result.message ?: "An unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }
}