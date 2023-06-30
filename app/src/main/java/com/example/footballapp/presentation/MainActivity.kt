package com.example.footballapp.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.example.footballapp.presentation.drawer.*
import com.example.footballapp.presentation.drawer.navigation.NavHostDrawer
import com.example.footballapp.presentation.drawer.navigation.NavigationDrawerScreen
import com.example.footballapp.ui.theme.FootballAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FootballAppTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()
                val navigationItems = listOf(
                    NavigationDrawerScreen.ChampionshipScreen,
                    NavigationDrawerScreen.EuropeTournamentScreen,
                    NavigationDrawerScreen.WorldCupScreen
                )
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(
                            onNavigationIconClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        )
                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        Drawer(
                            scope = scope,
                            scaffoldState = scaffoldState,
                            navController = navController,
                            items = navigationItems
                        )
                    }
                ) {
                    NavHostDrawer(navController = navController)
                }
            }
        }
    }
}