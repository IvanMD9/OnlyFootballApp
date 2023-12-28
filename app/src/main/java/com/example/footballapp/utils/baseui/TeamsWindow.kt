package com.example.footballapp.utils.baseui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.footballapp.R
import com.example.footballapp.domain.model.teams.TeamsModel
import com.example.footballapp.presentation.chempinship.navigation.NavigationScreen
import com.example.footballapp.presentation.chempinship.teams.components.ItemTeamInfo
import com.example.footballapp.utils.base.BaseViewModel

@Composable
inline fun <reified ViewModel : BaseViewModel<TeamsModel>> BaseTeamsWindow(
    viewModel: ViewModel,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.padding(horizontal = 6.dp)
        ) {
            state.value.data?.let { teams ->
                items(
                    items = teams.teams,
                    key = { team -> team.id }
                ) { result ->
                    ItemTeamInfo(
                        team = result,
                        onClickDetailTeam = {
                            navController
                                .navigate(
                                    route = NavigationScreen.TeamDetailScreen.route + "/${result.id}"
                                )
                        }
                    )
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