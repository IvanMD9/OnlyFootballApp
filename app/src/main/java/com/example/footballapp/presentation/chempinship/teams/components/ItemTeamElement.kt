package com.example.footballapp.presentation.chempinship.teams.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.footballapp.domain.model.detail_team.TeamDetailModel

@Composable
fun ItemTeamInfo(
    team: TeamDetailModel,
    onClickDetailTeam: () -> Unit
) {
    val itemTeam = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .decoderFactory(SvgDecoder.Factory())
            .data(team.crest)
            .build()
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClickDetailTeam() }
            .height(150.dp)
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.White,
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = itemTeam,
                contentDescription = null,
                modifier = Modifier
                    .size(110.dp),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}