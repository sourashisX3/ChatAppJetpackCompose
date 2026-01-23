package com.android.chatapp.features.chat.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
                DateHeader(date = "June 10, 2024")
                Spacer(modifier = Modifier.padding(bottom = 8.dp))

                ChatBubble(
                    chatMessage = "Hello! How can I help you today?"
                )
                Spacer(modifier = Modifier.padding(bottom = 8.dp))
                ChatBubble(
                    isRecipient = false,
                    chatMessage = "Hello"
                )
            }
        }
    }
}

@Composable
fun ChatBubble(
    modifier: Modifier = Modifier,
    chatMessage: String,
    isRecipient: Boolean = true
) {

    val colorScheme = MaterialTheme.colorScheme
    val bottomEndPadding = if (isRecipient) 8.dp else 0.dp
    val bottomStartPadding = if (isRecipient) 0.dp else 8.dp
    val textAlignment = if (isRecipient) Alignment.CenterStart else Alignment.CenterEnd
    val textColor = if (isRecipient) colorScheme.onSurface else colorScheme.surface
    val bubbleShape = RoundedCornerShape(
        topEnd = 8.dp,
        topStart = 8.dp,
        bottomEnd = bottomEndPadding,
        bottomStart = bottomStartPadding
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .align(if (isRecipient) Alignment.CenterStart else Alignment.CenterEnd)
                .widthIn(min = 80.dp, max = 250.dp)
                .clip(bubbleShape)
                .background(
                    color = if (isRecipient) colorScheme.onSurface.copy(alpha = 0.2f) else colorScheme.primary,
                    shape = bubbleShape
                )
                .padding(8.dp),
        ) {
            Text(
                text = chatMessage,
                color = textColor,
                modifier = Modifier.align(textAlignment)
            )
        }
    }
}

@Composable
fun DateHeader(
    modifier: Modifier = Modifier,
    date: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Text(
                text = date,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
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