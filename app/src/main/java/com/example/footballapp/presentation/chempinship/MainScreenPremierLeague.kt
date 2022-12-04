package com.example.footballapp.presentation.chempinship

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.footballapp.presentation.chempinship.detail_team.premier_league.TeamDetailPremierLeagueWindow
import com.example.footballapp.presentation.chempinship.matches.premier_league.MatchesPremierLeagueScreen
import com.example.footballapp.presentation.chempinship.navigation.NavigationScreen
import com.example.footballapp.presentation.chempinship.scores.premier_league.ScoresPremierLeagueScreen
import com.example.footballapp.presentation.chempinship.standing.ItemTabView
import com.example.footballapp.presentation.chempinship.standing.components.TabViewInfo
import com.example.footballapp.presentation.chempinship.standing.premier_league.StandingsPremierLeagueInfoViewModel
import com.example.footballapp.presentation.chempinship.standing.premier_league.StandingsPremierLeagueScreen
import com.example.footballapp.presentation.chempinship.team_matches.premier_league.TeamMatchesPremierLeagueWindow
import com.example.footballapp.presentation.chempinship.teams.premier_league.TeamsPremierLeagueWindow
import com.example.footballapp.presentation.constants.ScreenSection

@ExperimentalFoundationApi
@Composable
fun MainWindowPremierLeague(
    viewModel: StandingsPremierLeagueInfoViewModel = hiltViewModel()
) {
    val stateMain = viewModel.state.value
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                contentPadding = PaddingValues(horizontal = 16.dp),
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
                            painter = rememberAsyncImagePainter(model = stateMain.standingsInfo?.competition?.emblem),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "${stateMain.standingsInfo?.competition?.name}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                    }
                    Row(
                        modifier = Modifier.weight(1f),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "Сезон: ${stateMain.standingsInfo?.season?.startDate?.take(4)}" +
                                    "/${stateMain.standingsInfo?.season?.endDate?.take(4)}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    ) {
        Column {
            Spacer(
                modifier = Modifier
                    .height(6.dp)
                    .padding(it)
            )
            TabViewInfo(
                item = listOf(
                    ItemTabView(title = "Таблица"),
                    ItemTabView(title = "Бомбард."),
                    ItemTabView(title = "Команды"),
                    ItemTabView(title = "Матчи")
                ),
                modifier = Modifier.fillMaxWidth(),
                onTabSelected = {
                    selectedTabIndex = it
                }
            )
            when (selectedTabIndex) {
                0 -> ScreenSection { StandingsPremierLeagueScreen() }
                1 -> ScreenSection { ScoresPremierLeagueScreen() }
                2 -> ScreenSection {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavigationScreen.TeamsScreen.route
                    ) {
                        composable(route = NavigationScreen.TeamsScreen.route) {
                            TeamsPremierLeagueWindow(navController = navController)
                        }
                        composable(route = NavigationScreen.TeamDetailScreen.route + "/{detail_pl}") {
                            TeamDetailPremierLeagueWindow(navController = navController)
                        }
                        composable(route = NavigationScreen.TeamMatchesScreen.route + "/{team_matches_pl}") {
                            TeamMatchesPremierLeagueWindow()
                        }
                    }
                }
                3 -> ScreenSection { MatchesPremierLeagueScreen() }
            }
        }
    }
}