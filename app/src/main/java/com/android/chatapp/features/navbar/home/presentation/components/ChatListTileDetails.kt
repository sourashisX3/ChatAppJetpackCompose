package com.android.chatapp.features.navbar.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChatListTileDetails(
    modifier: Modifier = Modifier,
    userName: String,
    lastMessage: String,
    timestamp: String,
    unreadMessageCount: String,
    isMessageRead: Boolean,
    isMessageReadByRecipient: Boolean
) {

    val textTheme = MaterialTheme.typography
    val colorScheme = MaterialTheme.colorScheme
    val isUnreadMessage = unreadMessageCount != "0"

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = userName,
                maxLines = 1,
                style = textTheme.titleMedium
            )
            Text(
                text = timestamp,
                maxLines = 1,
                style = textTheme.bodySmall
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ChatUnreadMessages(
                isMessageRead = isMessageRead,
                lastMessage = lastMessage,
                isMessageReadByRecipient = isMessageReadByRecipient
            )
            if (isUnreadMessage)
                ChatUnreadMessageCount(unreadMessageCount = unreadMessageCount)
        }
    }
}