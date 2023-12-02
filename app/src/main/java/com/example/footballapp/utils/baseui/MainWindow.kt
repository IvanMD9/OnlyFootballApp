package com.example.footballapp.utils.baseui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.footballapp.R
import com.example.footballapp.domain.model.standing.StandingsModel
import com.example.footballapp.presentation.chempinship.navigation.NavigationScreen
import com.example.footballapp.presentation.chempinship.standing.ItemTabView
import com.example.footballapp.presentation.chempinship.standing.components.TabViewInfo
import com.example.footballapp.utils.AppDimensions
import com.example.footballapp.utils.base.BaseViewModel

@Composable
inline fun <reified ViewModel : BaseViewModel<StandingsModel>> BaseMainWindow(
    viewModel: ViewModel,
    crossinline standingWindow: @Composable () -> Unit,
    crossinline scoresWindow: @Composable () -> Unit,
    crossinline teamsWindow: @Composable (NavController) -> Unit,
    crossinline teamDetailingWindow: @Composable (NavController) -> Unit,
    crossinline teamMatchesWindow: @Composable () -> Unit,
    crossinline matchesWindow: @Composable () -> Unit,
    keyDetail: String,
    keyTeamMatches: String,
    modifier: Modifier = Modifier,
) {
    val stateMain = viewModel.state.collectAsState()

    val navController = rememberNavController()

    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                backgroundColor = colorResource(id = R.color.white),
                contentPadding = PaddingValues(horizontal = dimensionResource(id = R.dimen.horizontal_padding_medium)),
                elevation = 4.dp
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = stateMain.value.data?.competition?.emblem),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                        )
                        Spacer(
                            modifier = Modifier.width(
                                width = dimensionResource(id = R.dimen.horizontal_padding_small)
                            )
                        )
                        Text(
                            text = "${stateMain.value.data?.competition?.name}",
                            fontSize = AppDimensions.Text.lineHeightTextS,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(id = R.color.black),
                        )
                    }
                    Row(
                        modifier = Modifier.weight(1f),
                        horizontalArrangement = Arrangement.End
                    ) {
                        val startDate = stateMain.value.data?.season?.startDate?.take(4)
                        val endDate = stateMain.value.data?.season?.endDate?.take(4)
                        Text(
                            text = "${stringResource(id = R.string.app_main_screen_season)} $startDate/$endDate",
                            fontSize = AppDimensions.Text.lineHeightTextS,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(id = R.color.black),
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Column {
            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.vertical_padding_pre_small))
                    .padding(paddingValues)
            )
            // TODO: Переработать TabView
            TabViewInfo(
                item = listOf(
                    ItemTabView(title = stringResource(id = R.string.app_main_tab_standing)),
                    ItemTabView(title = stringResource(id = R.string.app_main_tab_scores)),
                    ItemTabView(title = stringResource(id = R.string.app_main_tab_teams)),
                    ItemTabView(title = stringResource(id = R.string.app_main_tab_matches)),
                ),
                modifier = Modifier.fillMaxWidth()
            ) { index ->
                selectedTabIndex = index
            }
            when (selectedTabIndex) {
                0 -> standingWindow()
                1 -> scoresWindow()
                2 -> {
                    NavHost(
                        navController = navController,
                        startDestination = NavigationScreen.TeamsScreen.route
                    ) {
                        composable(route = NavigationScreen.TeamsScreen.route) {
                            teamsWindow(navController)
                        }
                        composable(route = NavigationScreen.TeamDetailScreen.route + "/{${keyDetail}}") {
                            teamDetailingWindow(navController)
                        }
                        composable(route = NavigationScreen.TeamMatchesScreen.route + "/{${keyTeamMatches}}") {
                            teamMatchesWindow()
                        }
                    }
                }

                3 -> matchesWindow()
            }
        }
    }
}