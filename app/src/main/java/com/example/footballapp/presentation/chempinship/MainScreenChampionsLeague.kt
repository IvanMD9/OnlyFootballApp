package com.example.footballapp.presentation.chempinship

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.presentation.chempinship.detail_team.champions_league.TeamDetailChampionsLeagueWindow
import com.example.footballapp.presentation.chempinship.matches.champions_league.MatchesScreenChampionsLeague
import com.example.footballapp.presentation.chempinship.scores.champions_league.ScoresChampionsLeagueWindow
import com.example.footballapp.presentation.chempinship.standing.champions_league.StandingChampionsViewModel
import com.example.footballapp.presentation.chempinship.standing.champions_league.StandingChampionsWindow
import com.example.footballapp.presentation.chempinship.team_matches.champions_league.TeamMatchesChampionsLeagueWindow
import com.example.footballapp.presentation.chempinship.teams.champions_league.TeamsChampionsLeagueWindow
import com.example.footballapp.utils.Const
import com.example.footballapp.utils.baseui.BaseMainWindow

@ExperimentalFoundationApi
@Composable
fun MainWindowChampionsLeague(
    viewModel: StandingChampionsViewModel = hiltViewModel()
) {
    BaseMainWindow(
        viewModel = viewModel,
        standingWindow = { StandingChampionsWindow() },
        scoresWindow = { ScoresChampionsLeagueWindow() },
        teamsWindow = { navController ->
            TeamsChampionsLeagueWindow(navController = navController)
        },
        teamDetailingWindow = { navController ->
            TeamDetailChampionsLeagueWindow(navController = navController)
        },
        teamMatchesWindow = { TeamMatchesChampionsLeagueWindow() },
        matchesWindow = { MatchesScreenChampionsLeague() },
        keyDetail = Const.CHAMPIONS_DETAIL,
        keyTeamMatches = Const.CHAMPIONS_TEAM_MATCHES,
    )
}