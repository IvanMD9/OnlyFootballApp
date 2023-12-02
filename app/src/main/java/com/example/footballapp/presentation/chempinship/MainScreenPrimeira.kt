package com.example.footballapp.presentation.chempinship

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.presentation.chempinship.detail_team.primeira.TeamDetailPrimeiraWindow
import com.example.footballapp.presentation.chempinship.matches.primeira.MatchesScreenPrimeiraLiga
import com.example.footballapp.presentation.chempinship.scores.primeira.ScoresPrimeiraLigaScreen
import com.example.footballapp.presentation.chempinship.standing.primeira.StandingsPrimeiraLigaInfoViewModel
import com.example.footballapp.presentation.chempinship.standing.primeira.StandingsPrimeiraLigaScreen
import com.example.footballapp.presentation.chempinship.team_matches.primeira.TeamMatchesPrimeiraLigaWindow
import com.example.footballapp.presentation.chempinship.teams.primeira.TeamsPrimeiraLigaWindow
import com.example.footballapp.utils.Const
import com.example.footballapp.utils.baseui.BaseMainWindow

@ExperimentalFoundationApi
@Composable
fun MainWindowPrimeiraLiga(
    viewModel: StandingsPrimeiraLigaInfoViewModel = hiltViewModel()
) {
    BaseMainWindow(
        viewModel = viewModel,
        standingWindow = { StandingsPrimeiraLigaScreen() },
        scoresWindow = { ScoresPrimeiraLigaScreen() },
        teamsWindow = { navController ->
            TeamsPrimeiraLigaWindow(navController = navController)
        },
        teamDetailingWindow = { navController ->
            TeamDetailPrimeiraWindow(navController = navController)
        },
        teamMatchesWindow = { TeamMatchesPrimeiraLigaWindow() },
        matchesWindow = { MatchesScreenPrimeiraLiga() },
        keyDetail = Const.PRIMIERA_DETAIL,
        keyTeamMatches = Const.PRIMIERA_TEAM_MATCHES,
    )
}