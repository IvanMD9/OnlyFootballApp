package com.example.footballapp.presentation.chempinship.matches.premier_league

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseMatchesWindow

@ExperimentalFoundationApi
@Composable
fun MatchesPremierLeagueScreen() {
    val viewModel: MatchesPremierLeagueInfoViewModel = hiltViewModel()
    BaseMatchesWindow(viewModel = viewModel,
        onSelectMatch = viewModel::selectedMatchDialog,
        onDismiss = viewModel::dismissDialog)
}