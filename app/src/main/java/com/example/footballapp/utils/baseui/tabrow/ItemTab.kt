package com.example.footballapp.utils.baseui.tabrow

import androidx.annotation.StringRes
import com.example.footballapp.R

enum class ItemTab(
    val page: Int,
    @StringRes val title: Int
) {
    STANDING(
        page = 0,
        title = R.string.app_main_tab_standing
    ),
    SCORES(
        page = 1,
        title = R.string.app_main_tab_scores
    ),
    TEAMS(
        page = 2,
        title = R.string.app_main_tab_teams
    ),
    MATCHES(
        page = 3,
        title = R.string.app_main_tab_matches
    ),
}
