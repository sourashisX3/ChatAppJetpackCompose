package com.android.chatapp.features.navbar.home.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.chatapp.core.config.navigation.Screen
import com.android.chatapp.core.shared.miscellaneous.NoDataFoundScreen
import com.android.chatapp.features.navbar.home.presentation.components.ChatListTile
import com.android.chatapp.features.navbar.home.presentation.components.EndChatListMessage
import com.android.chatapp.features.navbar.home.presentation.components.UserProfilesAndNames
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val theme = MaterialTheme
    val colorScheme = theme.colorScheme
    val textTheme = theme.typography
    val chatIndices = remember { List(50) { it } }

    // Tab configuration
    val tabs = listOf("Chats", "Calls", "Groups")
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val coroutineScope = rememberCoroutineScope()

    // --- UI Structure ---
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // --- Modern Tab Row ---
        SecondaryTabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = colorScheme.surface,
            contentColor = colorScheme.primary,
            divider = { /* No divider*/ }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = title,
                            style = textTheme.titleMedium,
                            fontWeight = if (pagerState.currentPage == index) FontWeight.Bold else FontWeight.Normal,
                            color = if (pagerState.currentPage == index) colorScheme.primary else colorScheme.onSurface.copy(alpha = 0.6f)
                        )
                    }
                )
            }
        }

        // --- Horizontal Pager for Swipe Functionality ---
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) { page ->
            when (page) {
                0 -> ChatsPage(
                    chatIndices = chatIndices,
                    textTheme = textTheme,
                    navController = navController
                )
                1 -> CallsPage(
                    chatIndices = chatIndices,
                    textTheme = textTheme,
                    navController = navController
                )
                2 -> GroupsPage(
                    chatIndices = chatIndices,
                    textTheme = textTheme,
                    navController = navController
                )
            }
        }
    }
}

// --- Chats Page ---
@Composable
private fun ChatsPage(
    chatIndices: List<Int>,
    textTheme: Typography,
    navController: NavHostController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        // --- User Profiles Row ---
        item {
            LazyRow(modifier = Modifier.padding(vertical = 8.dp)) {
                items(10) { index ->
                    val showAddStory = index == 0
                    UserProfilesAndNames(
                        userName = if (showAddStory) "Add Story" else "User ${index - 1}",
                        isAddStory = showAddStory,
                        onClick = {
                            if (showAddStory) {
                                // Handle Add Story action
                            } else {
                                navController.navigate(Screen.Profile.route)
                            }
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }

        // --- Chats title ---
        item {
            Text(
                text = "Recent Chats",
                style = textTheme.titleLarge,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
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
                    isMessageReadByRecipient = index % 3 == 0,
                    onClick = { navController.navigate(Screen.Chat.route) }
                )
            }

            item {
                EndChatListMessage(
                    modifier = Modifier.padding(bottom = 56.dp, top = 16.dp)
                )
            }
        }
    }
}

// --- Calls Page ---
@Composable
private fun CallsPage(
    chatIndices: List<Int>,
    textTheme: Typography,
    navController: NavHostController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        // --- Calls title ---
        item {
            Text(
                text = "Recent Calls",
                style = textTheme.titleLarge,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
        }

        // --- Calls List (using same UI as chats for now) ---
        if (chatIndices.isEmpty()) {
            item { NoDataFoundScreen() }
        } else {
            items(chatIndices) { index ->
                ChatListTile(
                    imageUrl = "https://example.com/user/profile$index.jpg",
                    userName = "User $index",
                    lastMessage = "Called ${index} minutes ago",
                    timestamp = "12:${index}0 PM",
                    unreadMessageCount = 0,
                    isMessageRead = true,
                    isMessageReadByRecipient = false,
                    onClick = { navController.navigate(Screen.Chat.route) }
                )
            }

            item {
                EndChatListMessage(
                    modifier = Modifier.padding(bottom = 56.dp, top = 16.dp)
                )
            }
        }
    }
}

// --- Groups Page ---
@Composable
private fun GroupsPage(
    chatIndices: List<Int>,
    textTheme: Typography,
    navController: NavHostController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        // --- Groups title ---
        item {
            Text(
                text = "Groups",
                style = textTheme.titleLarge,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
        }

        // --- Groups List (using same UI as chats for now) ---
        if (chatIndices.isEmpty()) {
            item { NoDataFoundScreen() }
        } else {
            items(chatIndices) { index ->
                ChatListTile(
                    imageUrl = "https://example.com/user/profile$index.jpg",
                    userName = "Group $index",
                    lastMessage = "Last message in group $index",
                    timestamp = "12:${index}0 PM",
                    unreadMessageCount = index % 7,
                    isMessageRead = index % 2 == 0,
                    isMessageReadByRecipient = false,
                    onClick = { navController.navigate(Screen.Chat.route) }
                )
            }

            item {
                EndChatListMessage(
                    modifier = Modifier.padding(bottom = 56.dp, top = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = NavHostController(LocalContext.current))
}