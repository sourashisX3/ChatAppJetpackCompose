package com.android.chatapp.core.shared.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopBar(
    modifier: Modifier = Modifier,
    title: String,
    actions: @Composable RowScope.() -> Unit = {},
    navigationIcon: @Composable (() -> Unit) = {},
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    expandedHeight: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    val textTheme = MaterialTheme.typography

    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = title, style = textTheme.displaySmall)
        },
        actions = actions,
        navigationIcon = navigationIcon,
        colors = colors,
        expandedHeight = expandedHeight,
        windowInsets = windowInsets,
        scrollBehavior = scrollBehavior
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    title: String = "Blink Chat",
    onNotificationClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    onMoreOptionsClick: () -> Unit = {},
    isNotificationIconVisible: Boolean = true,
    isSearchIconVisible: Boolean = false,
    isMoreIconVisible: Boolean = false,
) {

    val actions: @Composable RowScope.() -> Unit = {

        // --- Search Icon ---
        if (isSearchIconVisible) {
            SearchIcon(onClick = onSearchClick)
            Spacer(modifier = Modifier.width(4.dp))
        }
        // --- More Options Icon ---
        if (isMoreIconVisible) {
            ThreeDotIcon(onClick = onMoreOptionsClick)
            Spacer(modifier = Modifier.width(4.dp))
        }
        // --- Notification Icon ---
        if (isNotificationIconVisible) {
            NotificationIcon(onClick = onNotificationClick)
            Spacer(modifier = Modifier.width(16.dp))

        }
    }

    CommonTopBar(
        modifier = modifier,
        title = title,
        actions = actions,
    )
}

@Preview(showBackground = true)
@Composable
fun AppTopBarPreview() {
    AppTopBar()
}