package com.example.footballapp.utils.baseui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.footballapp.R
import com.example.footballapp.domain.model.detail_team.TeamDetailModel
import com.example.footballapp.presentation.chempinship.detail_team.components.ItemPlayer
import com.example.footballapp.presentation.chempinship.detail_team.components.ItemTournament
import com.example.footballapp.utils.AppDimensions
import com.example.footballapp.utils.base.BaseViewModel

@Composable
inline fun <reified ViewModel : BaseViewModel<TeamDetailModel>> BaseTeamDetailWindow(
    viewModel: ViewModel,
    noinline onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState()

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = dimensionResource(id = R.dimen.horizontal_padding_large),
                    end = dimensionResource(id = R.dimen.horizontal_padding_large),
                    top = dimensionResource(id = R.dimen.horizontal_padding_medium),
                )
        ) {
            state.value.data?.let { detail ->
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(model = detail.crest),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(
                                        size = dimensionResource(id = R.dimen.icon_size_medium),
                                    ),
                                contentScale = ContentScale.FillBounds,
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = detail.shortName,
                                fontSize = AppDimensions.Text.textM,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.colorBlack),
                            )
                        }
                        Text(
                            text = stringResource(id = R.string.app_detail_team_matchmaking),
                            fontSize = AppDimensions.Text.textM,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.colorBlue),
                            modifier = Modifier.clickable(onClick = onClick),
                        )
                    }
                    Spacer(
                        modifier = Modifier.height(
                            height = dimensionResource(id = R.dimen.vertical_padding_small),
                        )
                    )
                    Text(
                        text = stringResource(id = R.string.app_detail_team_information_about_club),
                        fontSize = AppDimensions.Text.lineHeightTextS,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.colorBlack),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "${stringResource(id = R.string.app_detail_team_full_name)} ${detail.name}",
                        fontSize = AppDimensions.Text.textM,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.colorGray),
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "${stringResource(id = R.string.app_detail_team_club_colors)} ${detail.clubColors}",
                        fontSize = AppDimensions.Text.textM,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.colorGray),
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "${stringResource(id = R.string.app_detail_team_stadium)} ${detail.venue}",
                        fontSize = AppDimensions.Text.textM,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.colorGray),
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "${stringResource(id = R.string.app_detail_team_address)} ${detail.address}",
                        fontSize = AppDimensions.Text.textM,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.colorGray),
                    )
                    Spacer(
                        modifier = Modifier.height(
                            height = dimensionResource(id = R.dimen.vertical_padding_small),
                        )
                    )
                    Text(
                        text = stringResource(id = R.string.app_detail_team_tournament),
                        fontSize = AppDimensions.Text.lineHeightTextS,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.colorBlack),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                    ) {
                        items(
                            items = detail.runningCompetitions,
                            key = { competition -> competition.id }
                        ) { tournament ->
                            ItemTournament(tournament = tournament)
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(
                            height = dimensionResource(id = R.dimen.vertical_padding_medium),
                        )
                    )
                    Text(
                        text = stringResource(id = R.string.app_detail_team_coach),
                        fontSize = AppDimensions.Text.lineHeightTextS,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.colorBlack),
                    )
                    Spacer(
                        modifier = Modifier.height(
                            height = dimensionResource(id = R.dimen.vertical_padding_small),
                        )
                    )
                    Text(
                        text = "${stringResource(id = R.string.app_detail_team_name)} ${detail.coach.name}",
                        fontSize = AppDimensions.Text.textM,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.colorGray),
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "${stringResource(id = R.string.app_detail_team_nationality)} ${detail.coach.nationality}",
                        fontSize = AppDimensions.Text.textM,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.colorGray),
                    )
                    Spacer(
                        modifier = Modifier.height(
                            height = dimensionResource(id = R.dimen.vertical_padding_medium),
                        )
                    )
                    Text(
                        text = stringResource(id = R.string.app_detail_team_players),
                        fontSize = AppDimensions.Text.lineHeightTextS,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.colorBlack),
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                }
                items(
                    items = detail.squad,
                    key = { player -> player.id }
                ) { player ->
                    ItemPlayer(player = player)
                    Divider()
                }
            }
        }
        if (state.value.isLoading) {
            CircularProgressIndicator(
                color = colorResource(id = R.color.colorBlack),
            )
        }
    }
}