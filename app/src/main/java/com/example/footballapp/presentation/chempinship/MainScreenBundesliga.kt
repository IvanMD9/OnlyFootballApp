package com.example.footballapp.presentation.chempinship

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.presentation.chempinship.detail_team.bundesliga.TeamDetailBundesligaWindow
import com.example.footballapp.presentation.chempinship.matches.bundesliga.MatchesScreenBundesliga
import com.example.footballapp.presentation.chempinship.scores.bundesliga.ScoresBundesligaScreen
import com.example.footballapp.presentation.chempinship.standing.bundesliga.StandingsBundesligaInfoViewModel
import com.example.footballapp.presentation.chempinship.standing.bundesliga.StandingsBundesligaScreen
import com.example.footballapp.presentation.chempinship.team_matches.bundesliga.TeamMatchesBundesligaWindow
import com.example.footballapp.presentation.chempinship.teams.budesliga.TeamsBundesligaWindow
import com.example.footballapp.utils.Const
import com.example.footballapp.utils.baseui.BaseMainWindow

@ExperimentalFoundationApi
@Composable
fun MainWindowBundesliga(
    viewModel: StandingsBundesligaInfoViewModel = hiltViewModel()
) {
    BaseMainWindow(
        viewModel = viewModel,
        standingWindow = { StandingsBundesligaScreen() },
        scoresWindow = { ScoresBundesligaScreen() },
        teamsWindow = { navController ->
            TeamsBundesligaWindow(navController = navController)
        },
        teamDetailingWindow = { navController ->
            TeamDetailBundesligaWindow(navController = navController)
        },
        teamMatchesWindow = { TeamMatchesBundesligaWindow() },
        matchesWindow = { MatchesScreenBundesliga() },
        keyDetail = Const.BUNDESLIGA_DETAIL,
        keyTeamMatches = Const.BUNDESLIGA_TEAM_MATCHES,
    )
}