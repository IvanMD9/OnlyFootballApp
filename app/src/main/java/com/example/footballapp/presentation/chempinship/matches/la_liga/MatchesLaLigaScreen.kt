package com.example.footballapp.presentation.chempinship.matches.la_liga

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseMatchesWindow

@ExperimentalFoundationApi
@Composable
fun MatchesScreenLaLiga() {
    val viewModel: MatchesLaLigaInfoViewModel = hiltViewModel()
    BaseMatchesWindow(viewModel = viewModel)
}