package com.example.footballapp.presentation.chempinship

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.presentation.chempinship.detail_team.ligue_1.TeamDetailLigue1Window
import com.example.footballapp.presentation.chempinship.matches.ligue_1.MatchesScreenLigue1
import com.example.footballapp.presentation.chempinship.scores.ligue_1.ScoresLigue1Screen
import com.example.footballapp.presentation.chempinship.standing.ligue_1.StandingsLigue1InfoViewModel
import com.example.footballapp.presentation.chempinship.standing.ligue_1.StandingsLigue1Screen
import com.example.footballapp.presentation.chempinship.team_matches.ligue_1.TeamMatchesLigue1Window
import com.example.footballapp.presentation.chempinship.teams.ligue_1.TeamsLigue1Window
import com.example.footballapp.utils.Const
import com.example.footballapp.utils.baseui.BaseMainWindow

@ExperimentalFoundationApi
@Composable
fun MainWindowLigue1(
    viewModel: StandingsLigue1InfoViewModel = hiltViewModel()
) {
    BaseMainWindow(
        viewModel = viewModel,
        standingWindow = { StandingsLigue1Screen() },
        scoresWindow = { ScoresLigue1Screen() },
        teamsWindow = { navController ->
            TeamsLigue1Window(navController = navController)
        },
        teamDetailingWindow = { navController ->
            TeamDetailLigue1Window(navController = navController)
        },
        teamMatchesWindow = { TeamMatchesLigue1Window() },
        matchesWindow = { MatchesScreenLigue1() },
        keyDetail = Const.LIGUE_1_DETAIL,
        keyTeamMatches = Const.LIGUE_1_TEAM_MATCHES,
    )
}