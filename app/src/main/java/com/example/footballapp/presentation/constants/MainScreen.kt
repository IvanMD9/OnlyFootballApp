package com.example.footballapp.presentation.constants

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
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.footballapp.presentation.chempinship.standing.ItemTabView
import com.example.footballapp.presentation.chempinship.standing.components.TabViewInfo


// Реализовать позже, много шаблонного кода
@ExperimentalFoundationApi
@Composable
fun MainWindow(
    imageEmblem: String,
    nameChampionship: String,
    startDate: String,
    endDate: String,
    standingTournament: @Composable () -> Unit,
    scoresTournament: @Composable () -> Unit,
    teamsTournament: @Composable () -> Unit,
    teamDetailTournament: @Composable () -> Unit,
    teamMatchesTournament: @Composable () -> Unit,
    matchesTournament: @Composable () -> Unit,
) {
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
                            painter = rememberAsyncImagePainter(model = imageEmblem),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = nameChampionship,
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
                            text = "Сезон: ${startDate.take(4)}" +
                                    "/${endDate.take(4)}",
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
                modifier = Modifier.fillMaxWidth()
            ) {
                selectedTabIndex = it
            }
            when (selectedTabIndex) {
                0 -> ScreenSection { standingTournament() }
                1 -> ScreenSection { scoresTournament() }
                2 -> ScreenSection {
                    val navController = rememberNavController()
                    NavGraphForMainScreen(
                        navHostController = navController,
                        teamsTournament = { teamsTournament() },
                        teamDetailTournament = { teamDetailTournament() },
                        teamMatchesTournament = { teamMatchesTournament() })
                }
                3 -> ScreenSection { matchesTournament() }
            }
        }
    }
}