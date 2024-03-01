package com.example.footballapp.presentation.chempinship.matches.champions_league

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseMatchesWindow

@ExperimentalFoundationApi
@Composable
fun MatchesScreenChampionsLeague() {
    val viewModel: MatchesChampionsLeagueInfoViewModel = hiltViewModel()
    BaseMatchesWindow(
        viewModel = viewModel,
        onSelectMatch = viewModel::selectedMatchDialog,
        onDismiss = viewModel::dismissDialog,
        isEuropeLeague = true
    )
}