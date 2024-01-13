package com.example.footballapp.presentation.chempinship.matches.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.footballapp.R
import com.example.footballapp.domain.model.detail_team.AreaModel
import com.example.footballapp.domain.model.detailmatch.AssistModel
import com.example.footballapp.domain.model.detailmatch.AwayTeamModel
import com.example.footballapp.domain.model.detailmatch.CoachModelDetail
import com.example.footballapp.domain.model.detailmatch.DetailMatchModel
import com.example.footballapp.domain.model.detailmatch.GoalModel
import com.example.footballapp.domain.model.detailmatch.HomeTeamModel
import com.example.footballapp.domain.model.detailmatch.OddsModelDetail
import com.example.footballapp.domain.model.detailmatch.PlayerInModel
import com.example.footballapp.domain.model.detailmatch.PlayerOutModel
import com.example.footballapp.domain.model.detailmatch.ScoreModelDetail
import com.example.footballapp.domain.model.detailmatch.ScoreResultModel
import com.example.footballapp.domain.model.detailmatch.ScorerModelDetail
import com.example.footballapp.domain.model.detailmatch.SeasonModelDetail
import com.example.footballapp.domain.model.detailmatch.StatisticsModel
import com.example.footballapp.domain.model.detailmatch.SubstitutionModel
import com.example.footballapp.domain.model.detailmatch.TeamModelDetail
import com.example.footballapp.domain.model.matches.CompetitionModel
import com.example.footballapp.domain.model.matches.RefereeModel
import com.example.footballapp.domain.model.matches.TimeModel
import com.example.footballapp.presentation.constants.LoadImage
import com.example.footballapp.utils.AppDimensions

@Composable
fun MatchDetailDialog(
    match: DetailMatchModel?,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Dialog(onDismissRequest = onDismiss) {
        match?.let {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(10.dp)),
                backgroundColor = colorResource(id = R.color.white_dialog),
                elevation = 10.dp
            ) {
                Column(
                    modifier = Modifier.padding(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    LoadImage(
                        image = match.competition.emblem,
                        size = 24.dp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = match.competition.name,
                        fontSize = AppDimensions.Text.textM
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${stringResource(id = R.string.app_matches_matchday)} ${match.matchday}",
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ItemClub(
                            modifier = Modifier.weight(0.2f),
                            image = match.homeTeam.crest,
                            name = match.homeTeam.tla
                        )
                        Text(
                            modifier = Modifier.weight(0.6f),
                            text = match.venue,
                            fontSize = AppDimensions.Text.textM,
                            color = Color.DarkGray,
                            maxLines = 2,
                            textAlign = TextAlign.Center
                        )
                        ItemClub(
                            modifier = Modifier.weight(0.2f),
                            image = match.awayTeam.crest,
                            name = match.awayTeam.tla
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    // TODO: Не приходит со стороны backend
//                    SubTitle(text = stringResource(id = R.string.app_detail_team_coach))
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceAround,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(
//                            modifier = Modifier.weight(0.5f),
//                            text = match.homeTeam.coach?.name.orEmpty(),
//                            fontSize = 12.sp,
//                            color = Color.Gray,
//                            maxLines = 2,
//                            textAlign = TextAlign.Center
//                        )
//                        Text(
//                            modifier = Modifier.weight(0.5f),
//                            text = match.awayTeam.coach?.name.orEmpty(),
//                            fontSize = 12.sp,
//                            color = Color.Gray,
//                            maxLines = 2,
//                            textAlign = TextAlign.Center
//                        )
//                    }
//                    Spacer(modifier = Modifier.height(8.dp))
                    SubTitle(text = stringResource(id = R.string.app_matches_detail_dialog_referee))
                    Spacer(modifier = Modifier.height(8.dp))
                    match.referees.forEach { referee ->
                        Text(
                            text = referee.name,
                            fontSize = 12.sp,
                            color = Color.DarkGray,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    // TODO: Не приходит со стороны backend
//                    SubTitle(text = stringResource(id = R.string.app_matches_detail_dialog_goals))
//                    Spacer(modifier = Modifier.height(4.dp))
//                    match.goals.forEach { goals ->
//                        PlayersGoals(
//                            minute = goals.minute.toString(),
//                            scorer = goals.scorer.name,
//                            homeTeam = goals.team.name == match.homeTeam.name
//                        )
//                    }
                }
            }
        }
    }
}

@Composable
private fun ItemClub(
    image: String,
    name: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoadImage(
            image = image,
            size = 30.dp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = name,
            fontSize = AppDimensions.Text.displayM,
            color = Color.Black
        )
    }
}

@Composable
private fun SubTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        color = Color.Black
    )
}

@Composable
private fun PlayersGoals(
    minute: String,
    scorer: String,
    homeTeam: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = if (homeTeam) {
            Alignment.Start
        } else {
            Alignment.End
        }
    ) {
        Row {
            Image(
                modifier = Modifier.size(18.dp),
                painter = painterResource(id = R.drawable.ball),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = "$minute - $scorer",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

@Preview
@Composable
private fun MatchDetailDialogPreview() {
    val dialog = DetailMatchModel(
        area = AreaModel(
            code = "",
            flag = null,
            id = 0,
            name = ""
        ),
        attendance = 0,
        awayTeam = AwayTeamModel(
            bench = emptyList(),
            coach = CoachModelDetail(
                id = 0,
                name = "Josep Guardiola",
                nationality = "",
            ),
            crest = "https://crests.football-data.org/66.png",
            formation = "4-4-2",
            id = 0,
            leagueRank = null,
            lineup = emptyList(),
            name = "Manchester United",
            shortName = "Man United",
            statistics = StatisticsModel(
                ball_possession = 75,
                corner_kicks = 2,
                fouls = 12,
                free_kicks = 3,
                goal_kicks = 2,
                offsides = 6,
                red_cards = 1,
                saves = 5,
                shots = 13,
                shots_on_goal = 2,
                shots_off_goal = 11,
                throw_ins = 0,
                yellow_cards = 4,
                yellow_red_cards = 2,
            ),
            tla = "MUN",
        ),
        bookings = emptyList(),
        competition = CompetitionModel(
            code = "",
            emblem = "https://crests.football-data.org/PL.png",
            id = 0,
            name = "Premier League",
            type = ""
        ),
        goals = listOf(
            GoalModel(
                assist = AssistModel(0, ""),
                injuryTime = "",
                minute = 25,
                score = ScoreModelDetail(
                    away = 1,
                    home = 0
                ),
                scorer = ScorerModelDetail(
                    id = 0,
                    name = "Jadon Sancho",
                ),
                team = TeamModelDetail(
                    id = 0,
                    name = "Manchester United"
                ),
                type = ""
            ),
        ),
        group = null,
        homeTeam = HomeTeamModel(
            bench = emptyList(),
            coach = CoachModelDetail(
                id = 0,
                name = "Josep Guardiola",
                nationality = "",
            ),
            crest = "https://crests.football-data.org/340.png",
            formation = "4-4-2",
            id = 0,
            leagueRank = "",
            lineup = emptyList(),
            name = "Southampton",
            shortName = "Southampton",
            statistics = StatisticsModel(
                ball_possession = 75,
                corner_kicks = 2,
                fouls = 12,
                free_kicks = 3,
                goal_kicks = 2,
                offsides = 6,
                red_cards = 1,
                saves = 5,
                shots = 13,
                shots_on_goal = 2,
                shots_off_goal = 11,
                throw_ins = 0,
                yellow_cards = 4,
                yellow_red_cards = 2,
            ),
            tla = "SOU",
        ),
        id = 0,
        injuryTime = 0,
        lastUpdated = "",
        matchday = 1,
        minute = 90,
        odds = OddsModelDetail(
            awayWin = 1.45,
            draw = 4.5,
            homeWin = 2.2,
        ),
        penalties = emptyList(),
        referees = listOf(
            RefereeModel(
                id = 0,
                name = "Stuart Attwell",
                nationality = "",
                type = "REFEREE"
            )
        ),
        score = ScoreResultModel(
            duration = "",
            fullTime = TimeModel(
                away = 0,
                home = 3,
            ),
            halfTime = TimeModel(
                away = 0,
                home = 1,
            ),
            winner = ""
        ),
        season = SeasonModelDetail(
            currentMatchday = 1,
            endDate = "",
            id = 0,
            stages = emptyList(),
            startDate = "",
            winner = null
        ),
        stage = "",
        status = "",
        substitutions = listOf(
            SubstitutionModel(
                minute = 0,
                playerIn = PlayerInModel(0, ""),
                playerOut = PlayerOutModel(1, ""),
                team = TeamModelDetail(0, "")
            )
        ),
        utcDate = "",
        venue = "Old Trafford"
    )
    MatchDetailDialog(
        match = dialog,
        onDismiss = {}
    )
}