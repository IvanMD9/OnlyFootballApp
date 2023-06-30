package com.example.footballapp.presentation.chempinship.scores.bundesliga

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.presentation.chempinship.scores.components.ItemScoresInfo

@Composable
fun ScoresBundesligaScreen(
    viewModel: ScoresBundesligaInfoViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        // TODO: Добавить проверку во все экраны
        if (state.value.data?.scorers?.isEmpty() == true) {
            Text(
                text = "Список пустой",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                state.value.data?.let {
                    items(it.scorers) { result ->
                        ItemScoresInfo(scorer = result)
                        Divider(Modifier.height(1.dp))
                    }
                }
            }
        }
        if (state.value.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.Black
            )
        }
    }
}