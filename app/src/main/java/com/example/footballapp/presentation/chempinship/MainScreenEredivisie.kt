package com.example.footballapp.presentation.chempinship

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.presentation.chempinship.detail_team.eredivisie.TeamDetailEredivisieWindow
import com.example.footballapp.presentation.chempinship.matches.eredivisie.MatchesScreenEredivisie
import com.example.footballapp.presentation.chempinship.scores.eredivisie.ScoresEredivisieScreen
import com.example.footballapp.presentation.chempinship.standing.eredivisie.StandingsEredivisieInfoViewModel
import com.example.footballapp.presentation.chempinship.standing.eredivisie.StandingsEredivisieScreen
import com.example.footballapp.presentation.chempinship.team_matches.eredivisie.TeamMatchesEredivisieWindow
import com.example.footballapp.presentation.chempinship.teams.eredivisie.TeamsEredivisieWindow
import com.example.footballapp.utils.Const
import com.example.footballapp.utils.baseui.BaseMainWindow

@ExperimentalFoundationApi
@Composable
fun MainWindowEredivisie(
    viewModel: StandingsEredivisieInfoViewModel = hiltViewModel()
) {
    BaseMainWindow(
        viewModel = viewModel,
        standingWindow = { StandingsEredivisieScreen() },
        scoresWindow = { ScoresEredivisieScreen() },
        teamsWindow = { navController ->
            TeamsEredivisieWindow(navController = navController)
        },
        teamDetailingWindow = { navController ->
            TeamDetailEredivisieWindow(navController = navController)
        },
        teamMatchesWindow = { TeamMatchesEredivisieWindow() },
        matchesWindow = { MatchesScreenEredivisie() },
        keyDetail = Const.EREDIVISIE_DETAIL,
        keyTeamMatches = Const.EREDIVISIE_TEAM_MATCHES,
    )
}