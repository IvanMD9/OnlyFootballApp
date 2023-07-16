package com.example.footballapp.utils.baseui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.footballapp.R
import com.example.footballapp.domain.model.team_matches.TeamMatchesModel
import com.example.footballapp.presentation.chempinship.team_matches.components.ItemTeamMatches
import com.example.footballapp.utils.base.BaseViewModel

@Composable
inline fun <reified ViewModel : BaseViewModel<TeamMatchesModel>> BaseTeamMatchesWindow(
    viewModel: ViewModel,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState()

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            state.value.data?.let { teamMatches ->
                items(teamMatches.matches) { result ->
                    ItemTeamMatches(teamMatches = result)
                }
            }
        }
        if (state.value.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = colorResource(id = R.color.colorBlack),
            )
        }
    }
}