package com.example.footballapp.presentation.chempinship.matches.bundesliga

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseMatchesWindow

@ExperimentalFoundationApi
@Composable
fun MatchesScreenBundesliga() {
    val viewModel: MatchesBundesligaInfoViewModel = hiltViewModel()
    BaseMatchesWindow(
        viewModel = viewModel,
        onSelectMatch = viewModel::selectedMatchDialog,
        onDismiss = viewModel::dismissDialog
    )
}