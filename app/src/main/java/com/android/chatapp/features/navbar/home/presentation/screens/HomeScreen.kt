package com.android.chatapp.features.navbar.home.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
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

    // --- UI ---
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        HomeScreenTopBar()
        Spacer(modifier = Modifier.padding(8.dp))

        // --- User Profiles and Names Row ---
        LazyRow(
            modifier = Modifier
        ) {
            items(10) { index ->
                UserProfilesAndNames(
                    userName = "User $index",
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }

        // --- chat list ---
        Text(
            text = "Chats",
            style = textTheme.titleLarge,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        LazyColumn(
            modifier = Modifier
        ) {
            items(50) { index ->
                ChatListTile(
                    imageUrl = "https://example.com/user/profile$index.jpg",
                    userName = "User $index",
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