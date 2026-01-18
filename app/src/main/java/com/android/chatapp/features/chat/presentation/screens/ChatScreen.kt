package com.android.chatapp.features.chat.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.chatapp.features.chat.presentation.components.ChatScreenTopBar
import com.android.chatapp.features.chat.presentation.components.SendMessageBox

@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            ChatScreenTopBar(
                userName = "Sourashis Das",
                userStatus = "Online",
                onBackClick = { navController.popBackStack() },
                onCallClick = { /* TODO: Implement call action */ },
                onVideoCallClick = { /* TODO: Implement video call action */ }
            )
        },
        bottomBar = {
            SendMessageBox()
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {

        }
    }
}


@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen(
        navController = NavHostController(LocalContext.current)
    )
}