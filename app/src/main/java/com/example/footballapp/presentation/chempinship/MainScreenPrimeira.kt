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
import com.example.footballapp.presentation.chempinship.detail_team.primeira.TeamDetailPrimeiraLigaWindow
import com.example.footballapp.presentation.chempinship.matches.primeira.MatchesScreenPrimeiraLiga
import com.example.footballapp.presentation.chempinship.navigation.NavigationScreen
import com.example.footballapp.presentation.chempinship.scores.primeira.ScoresPrimeiraLigaScreen
import com.example.footballapp.presentation.chempinship.standing.ItemTabView
import com.example.footballapp.presentation.chempinship.standing.components.TabViewInfo
import com.example.footballapp.presentation.chempinship.standing.primeira.StandingsPrimeiraLigaInfoViewModel
import com.example.footballapp.presentation.chempinship.standing.primeira.StandingsPrimeiraLigaScreen
import com.example.footballapp.presentation.chempinship.team_matches.primeira.TeamMatchesPrimeiraLigaWindow
import com.example.footballapp.presentation.chempinship.teams.primeira.TeamsPrimeiraLigaWindow
import com.example.footballapp.presentation.constants.ScreenSection
import com.example.footballapp.utils.Const

@ExperimentalFoundationApi
@Composable
fun MainWindowPrimeiraLiga(
    viewModel: StandingsPrimeiraLigaInfoViewModel = hiltViewModel()
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
                            text = "??????????: ${stateMain.standingsInfo?.season?.startDate?.take(4)}" +
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
                    ItemTabView(title = "??????????????"),
                    ItemTabView(title = "??????????????."),
                    ItemTabView(title = "??????????????"),
                    ItemTabView(title = "??????????")
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                selectedTabIndex = it
            }
            when (selectedTabIndex) {
                0 -> ScreenSection { StandingsPrimeiraLigaScreen() }
                1 -> ScreenSection { ScoresPrimeiraLigaScreen() }
                2 -> ScreenSection {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavigationScreen.TeamsScreen.route
                    ) {
                        composable(route = NavigationScreen.TeamsScreen.route) {
                            TeamsPrimeiraLigaWindow(navController = navController)
                        }
                        composable(route = NavigationScreen.TeamDetailScreen.route + "/{${Const.PRIMIERA_DETAIL}}") {
                            TeamDetailPrimeiraLigaWindow(navController = navController)
                        }
                        composable(route = NavigationScreen.TeamMatchesScreen.route + "/{${Const.PRIMIERA_TEAM_MATCHES}}") {
                            TeamMatchesPrimeiraLigaWindow()
                        }
                    }
                }
                3 -> ScreenSection { MatchesScreenPrimeiraLiga() }
            }
        }
    }
}