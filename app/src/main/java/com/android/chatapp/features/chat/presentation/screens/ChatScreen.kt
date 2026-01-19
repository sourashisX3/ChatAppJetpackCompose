package com.android.chatapp.features.chat.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.chatapp.features.chat.presentation.components.SendMessageBox

@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Scaffold(
        bottomBar = {
            SendMessageBox()
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            items(1) {
                ChatBubble(
                    chatMessage = "Hello! How can I help you today?"
                )
            }
        }
    }
}

@Composable
fun ChatBubble(
    modifier: Modifier = Modifier,
    chatMessage: String
) {

    val colorScheme = MaterialTheme.colorScheme

    Box(
        modifier = modifier
            .background(
                color = colorScheme.onSurface.copy(alpha = 0.2f),
                shape = RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp, bottomEnd = 8.dp)
            )
            .padding(8.dp)
            .clip(RoundedCornerShape(topEnd = 8.dp, bottomStart = 8.dp, bottomEnd = 8.dp))
    ) {
        Text(text = chatMessage)
    }

}


@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen(
        navController = NavHostController(LocalContext.current)
    )
}