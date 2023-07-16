package com.example.footballapp.presentation.chempinship.matches.ligue_1

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseMatchesWindow

@ExperimentalFoundationApi
@Composable
fun MatchesScreenLigue1() {
    val viewModel: MatchesLigue1InfoViewModel = hiltViewModel()
    BaseMatchesWindow(viewModel = viewModel)
}