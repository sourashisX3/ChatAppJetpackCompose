package com.android.chatapp.features.navbar.home.presentation.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.chatapp.core.shared.miscellaneous.NoDataFoundScreen
import com.android.chatapp.features.navbar.home.presentation.components.ChatListTile
import com.android.chatapp.features.navbar.home.presentation.components.HomeScreenTopBar
import com.android.chatapp.features.navbar.home.presentation.components.UserProfilesAndNames


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val theme = MaterialTheme
    val textTheme = theme.typography

    val chatIndices = remember { List(50) { it } }

    // --- UI ---
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            HomeScreenTopBar()
            Spacer(modifier = Modifier.padding(8.dp))
        }

        // --- User Profiles Row ---
        item {
            LazyRow {
                items(10) { index ->
                    UserProfilesAndNames(
                        userName = "User $index",
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }

        // --- Chats title ---
        item {
            Text(
                text = "Chats",
                style = textTheme.titleLarge,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
        }
        // --- Chat List ---
        if (chatIndices.isEmpty()) {
            item { NoDataFoundScreen() }
        } else {
            items(chatIndices) { index ->
                ChatListTile(
                    imageUrl = "https://example.com/user/profile$index.jpg",
                    userName = "User $index",
                    lastMessage = "Last message from User $index",
                    timestamp = "12:${index}0 PM",
                    unreadMessageCount = index % 5,
                    isMessageRead = index % 2 == 0,
                    isMessageReadByRecipient = index % 3 == 0
                )
                Spacer(modifier = Modifier.padding(bottom = 8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = NavHostController(LocalContext.current))
}