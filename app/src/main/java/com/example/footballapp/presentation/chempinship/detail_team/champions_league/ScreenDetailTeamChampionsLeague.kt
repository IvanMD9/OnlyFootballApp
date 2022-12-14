package com.example.footballapp.presentation.chempinship.detail_team.champions_league

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.footballapp.presentation.chempinship.detail_team.components.ItemPlayer
import com.example.footballapp.presentation.chempinship.detail_team.components.ItemTournament
import com.example.footballapp.presentation.chempinship.navigation.NavigationScreen

@Composable
fun TeamDetailChampionsLeagueWindow(
    viewModel: TeamDetailChampionsLeagueViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 16.dp)
    ) {
        state.teamDetailInfo?.let { detail ->
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = detail.crest),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            contentScale = ContentScale.FillBounds
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = detail.shortName,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "?????????????????????? ????????????",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Blue,
                            modifier = Modifier.clickable {
                                navController.navigate(NavigationScreen.TeamMatchesScreen.route + "/${detail.id}")
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "???????????????????? ?? ??????????",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "???????????? ????????????????: ${detail.name}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "?????????????? ??????????: ${detail.clubColors}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "??????????????: ${detail.venue}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "??????????: ${detail.address}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "??????????????",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(10.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    items(detail.runningCompetitions) {
                        ItemTournament(tournament = it)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "????????????",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "??????: ${detail.coach.name}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "????????????????????????????: ${detail.coach.nationality}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "????????????",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(6.dp))
            }
            items(detail.squad) {
                ItemPlayer(player = it)
                Divider()
            }
        }
    }
}