package com.example.footballapp.presentation.chempinship.matches.ligue_1

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.presentation.chempinship.matches.components.ItemMatch

@ExperimentalFoundationApi
@Composable
fun MatchesScreenLigue1(
    viewModel: MatchesLigue1InfoViewModel = hiltViewModel()
) {

    val state = viewModel.state.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        val grouped = state.value.data?.matches?.groupBy { it.matchday }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            grouped?.forEach { (matchDay, matches) ->
                stickyHeader {
                    Text(
                        text = "Тур: $matchDay",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                items(matches) { result ->
                    ItemMatch(match = result)
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