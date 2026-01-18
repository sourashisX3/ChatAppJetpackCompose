package com.android.chatapp.features.navbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.chatapp.R

data class NavItem(
    val route: String,
    val title: String,
    val iconRes: Int,
    val selectedIconRes: Int,
    val matchRoutes: List<String> = listOf(route)
)


@Composable
fun AppNavBar(
    modifier: Modifier = Modifier,
    currentRoute: String,
    onNavigate: (route: String) -> Unit,
    navItems: List<NavItem>
) {

    val colorScheme = MaterialTheme.colorScheme
    val textTheme = MaterialTheme.typography

    NavigationBar(
        modifier = modifier.fillMaxWidth(),
        containerColor = colorScheme.surface,
        contentColor = colorScheme.onSurface,
    ) {
        navItems.forEach { item ->
            val selected = item.matchRoutes.any { match ->
                currentRoute == match || currentRoute.startsWith(match)
            }

            NavigationBarItem(
                selected = selected,
                onClick = { if (!selected) onNavigate(item.route) },
                colors = NavigationBarItemDefaults.colors(
                   /* selectedIconColor = colorScheme.primary,
                    unselectedIconColor = colorScheme.onSurface,
                    selectedTextColor = colorScheme.primary,
                    unselectedTextColor = colorScheme.onSurface,*/
                    indicatorColor = colorScheme.primary.copy(alpha = 0.15f)
                ),
                icon = {
                    Icon(
                        painter = painterResource(id = if (selected) item.selectedIconRes else item.iconRes),
                        contentDescription = item.title,
                        tint = if (selected) colorScheme.primary else colorScheme.onSurface,
                        modifier = Modifier.size(18.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title, style = textTheme.labelLarge.copy(
                            color = if (selected) colorScheme.primary else colorScheme.onSurface
                        )
                    )

                }
            )
        }
    }
}


// --- Future use: Add Chat Button ---
@Composable
fun AddChat(
    modifier: Modifier = Modifier,
    text: String,
    icon: Int
) {
    val colorScheme = MaterialTheme.colorScheme
    Box(
        modifier = modifier
            .height(42.dp)
            .width(150.dp)
            .clip(CircleShape)
            .background(color = colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = text,
                tint = colorScheme.onPrimary,
                modifier = Modifier
                    .size(16.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = colorScheme.onPrimary
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddChatPreview() {
    AddChat(
        text = "New Chat",
        icon = R.drawable.add_ic
    )
}