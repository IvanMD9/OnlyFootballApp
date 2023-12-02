package com.example.footballapp.presentation.chempinship

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.presentation.chempinship.detail_team.world_cup.TeamDetailWorldCupWindow
import com.example.footballapp.presentation.chempinship.matches.world_cup.MatchesScreenWorldCup
import com.example.footballapp.presentation.chempinship.scores.world_cup.ScoresWorldCupWindow
import com.example.footballapp.presentation.chempinship.standing.world_cup.StandingWorldCupViewModel
import com.example.footballapp.presentation.chempinship.standing.world_cup.StandingWorldCupWindow
import com.example.footballapp.presentation.chempinship.team_matches.world_cup.TeamMatchesWorldCupWindow
import com.example.footballapp.presentation.chempinship.teams.world_cup.TeamsWorldCupWindow
import com.example.footballapp.utils.Const
import com.example.footballapp.utils.baseui.BaseMainWindow

@ExperimentalFoundationApi
@Composable
fun MainWindowWorldCup(
    viewModel: StandingWorldCupViewModel = hiltViewModel()
) {
    BaseMainWindow(
        viewModel = viewModel,
        standingWindow = { StandingWorldCupWindow() },
        scoresWindow = { ScoresWorldCupWindow() },
        teamsWindow = { navController ->
            TeamsWorldCupWindow(navController = navController)
        },
        teamDetailingWindow = { navController ->
            TeamDetailWorldCupWindow(navController = navController)
        },
        teamMatchesWindow = { TeamMatchesWorldCupWindow() },
        matchesWindow = { MatchesScreenWorldCup() },
        keyDetail = Const.WC_DETAIL,
        keyTeamMatches = Const.WC_TEAM_MATCHES,
    )
}