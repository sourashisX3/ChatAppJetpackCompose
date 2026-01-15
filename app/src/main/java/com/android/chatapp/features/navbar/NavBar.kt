package com.android.chatapp.features.navbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter


data class NavItem(
    val id: String,
    val title: String,
    val icon: Painter
)

@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    navItems: List<NavItem>,
    onItemSelected: (NavItem) -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        navItems.forEach { item ->
            NavBarItem(
                item = item,
                onClick = { onItemSelected(item) }
            )
        }
    }
}

@Composable
fun NavBarItem(
    modifier: Modifier = Modifier,
    item: NavItem, onClick: () -> Unit
) {
    Box(

    ) {
        // Here you would typically add an Icon and Text composable to display the icon and title
        // For example:
        // Icon(painter = item.icon, contentDescription = item.title)
        // Text(text = item.title)
    }
}