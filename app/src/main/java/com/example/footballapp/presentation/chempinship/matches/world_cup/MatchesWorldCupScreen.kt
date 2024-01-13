package com.example.footballapp.presentation.chempinship.matches.world_cup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseMatchesWindow

@ExperimentalFoundationApi
@Composable
fun MatchesScreenWorldCup() {
    val viewModel: MatchesWorldCupViewModel = hiltViewModel()
    BaseMatchesWindow(viewModel = viewModel,
        onSelectMatch = viewModel::selectedMatchDialog,
        onDismiss = viewModel::dismissDialog)
}