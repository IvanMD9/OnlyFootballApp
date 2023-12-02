package com.example.footballapp.presentation.chempinship

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.presentation.chempinship.detail_team.la_liga.TeamDetailLaLigaWindow
import com.example.footballapp.presentation.chempinship.matches.la_liga.MatchesScreenLaLiga
import com.example.footballapp.presentation.chempinship.scores.la_liga.ScoresLaLigaScreen
import com.example.footballapp.presentation.chempinship.standing.la_liga.StandingLaLiagScreen
import com.example.footballapp.presentation.chempinship.standing.la_liga.StandingsLaLigaInfoViewModel
import com.example.footballapp.presentation.chempinship.team_matches.la_liga.TeamMatchesLaLigaWindow
import com.example.footballapp.presentation.chempinship.teams.la_liga.TeamsLaLigaWindow
import com.example.footballapp.utils.Const
import com.example.footballapp.utils.baseui.BaseMainWindow

@ExperimentalFoundationApi
@Composable
fun MainWindowLaLiga(
    viewModel: StandingsLaLigaInfoViewModel = hiltViewModel()
) {
    BaseMainWindow(
        viewModel = viewModel,
        standingWindow = { StandingLaLiagScreen() },
        scoresWindow = { ScoresLaLigaScreen() },
        teamsWindow = { navController ->
            TeamsLaLigaWindow(navController = navController)
        },
        teamDetailingWindow = { navController ->
            TeamDetailLaLigaWindow(navController = navController)
        },
        teamMatchesWindow = { TeamMatchesLaLigaWindow() },
        matchesWindow = { MatchesScreenLaLiga() },
        keyDetail = Const.LA_LIGA_DETAIL,
        keyTeamMatches = Const.LA_LIGA_TEAM_MATCHES,
    )
}