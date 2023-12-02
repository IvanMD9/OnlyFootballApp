package com.example.footballapp.presentation.chempinship

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.presentation.chempinship.detail_team.premier_league.TeamDetailPremierLeagueWindow
import com.example.footballapp.presentation.chempinship.matches.premier_league.MatchesPremierLeagueScreen
import com.example.footballapp.presentation.chempinship.scores.premier_league.ScoresPremierLeagueScreen
import com.example.footballapp.presentation.chempinship.standing.premier_league.StandingsPremierLeagueInfoViewModel
import com.example.footballapp.presentation.chempinship.standing.premier_league.StandingsPremierLeagueScreen
import com.example.footballapp.presentation.chempinship.team_matches.premier_league.TeamMatchesPremierLeagueWindow
import com.example.footballapp.presentation.chempinship.teams.premier_league.TeamsPremierLeagueWindow
import com.example.footballapp.utils.Const
import com.example.footballapp.utils.baseui.BaseMainWindow

@ExperimentalFoundationApi
@Composable
fun MainWindowPremierLeague(
    viewModel: StandingsPremierLeagueInfoViewModel = hiltViewModel()
) {
    BaseMainWindow(
        viewModel = viewModel,
        standingWindow = { StandingsPremierLeagueScreen() },
        scoresWindow = { ScoresPremierLeagueScreen() },
        teamsWindow = { navController ->
            TeamsPremierLeagueWindow(navController = navController)
        },
        teamDetailingWindow = { navController ->
            TeamDetailPremierLeagueWindow(navController = navController)
        },
        teamMatchesWindow = { TeamMatchesPremierLeagueWindow() },
        matchesWindow = { MatchesPremierLeagueScreen() },
        keyDetail = Const.PREMIER_LEAGUE_DETAIL,
        keyTeamMatches = Const.PREMIER_LEAGUE_TEAM_MATCHES,
    )
}