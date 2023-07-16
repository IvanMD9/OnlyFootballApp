package com.example.footballapp.presentation.chempinship.matches.eredivisie

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseMatchesWindow

@ExperimentalFoundationApi
@Composable
fun MatchesScreenEredivisie() {
    val viewModel: MatchesEredivisieInfoViewModel = hiltViewModel()
    BaseMatchesWindow(viewModel = viewModel)
}