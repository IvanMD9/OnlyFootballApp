package com.example.footballapp.utils.baseui.tabrow

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppTabRow(
    pagerState: PagerState,
    onTabSelected: (ItemTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    val coroutineScope = rememberCoroutineScope()

    TabRow(
        modifier = modifier,
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Transparent,
        divider = {
            TabRowDefaults.Divider(
                color = Color.Transparent,
            )
        },
        indicator = { listOfTabPosition ->
            val tabPosition = listOfTabPosition[pagerState.currentPage]
            AppTabIndicator(
                modifier = Modifier.tabIndicatorOffset(tabPosition),
            )
        },
        tabs = {
            ItemTab.values().forEach { itemTab ->
                AppTab(
                    titleRes = itemTab.title,
                    isSelected = itemTab.page == pagerState.currentPage,
                    onTabClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(itemTab.page)
                        }
                        onTabSelected(itemTab)
                    }
                )
            }
        }
    )
}