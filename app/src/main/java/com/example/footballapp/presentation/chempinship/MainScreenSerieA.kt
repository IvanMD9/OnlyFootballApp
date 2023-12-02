package com.example.footballapp.presentation.chempinship

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.presentation.chempinship.detail_team.serie_a.TeamDetailSerieAWindow
import com.example.footballapp.presentation.chempinship.matches.serie_a.MatchesScreenSerieA
import com.example.footballapp.presentation.chempinship.scores.serie_a.ScoresSerieAScreen
import com.example.footballapp.presentation.chempinship.standing.serie_a.StandingsSerieAInfoViewModel
import com.example.footballapp.presentation.chempinship.standing.serie_a.StandingsSerieAScreen
import com.example.footballapp.presentation.chempinship.team_matches.serie_a.TeamMatchesSerieAWindow
import com.example.footballapp.presentation.chempinship.teams.serie_a.TeamsSerieAWindow
import com.example.footballapp.utils.Const
import com.example.footballapp.utils.baseui.BaseMainWindow

@ExperimentalFoundationApi
@Composable
fun MainWindowSerieA(
    viewModel: StandingsSerieAInfoViewModel = hiltViewModel()
) {
    BaseMainWindow(
        viewModel = viewModel,
        standingWindow = { StandingsSerieAScreen() },
        scoresWindow = { ScoresSerieAScreen() },
        teamsWindow = { navController ->
            TeamsSerieAWindow(navController = navController)
        },
        teamDetailingWindow = { navController ->
            TeamDetailSerieAWindow(navController = navController)
        },
        teamMatchesWindow = { TeamMatchesSerieAWindow() },
        matchesWindow = { MatchesScreenSerieA() },
        keyDetail = Const.SERIE_A_DETAIL,
        keyTeamMatches = Const.SERIE_A_TEAM_MATCHES,
    )
}