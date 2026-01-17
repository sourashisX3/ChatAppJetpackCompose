package com.android.chatapp.features.navbar.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.chatapp.core.shared.components.UserAvatar
import com.android.chatapp.ui.theme.ChatAppTheme

@Composable
fun ChatListTile(
    modifier: Modifier = Modifier,
    imageUrl: String,
    userName: String,
    lastMessage: String? = null,
    timestamp: String,
    unreadMessageCount: Int = 0,
    isMessageRead: Boolean = false,
    isMessageReadByRecipient: Boolean = false,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(16))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            UserAvatar(imageUrl = imageUrl)
            Spacer(modifier = Modifier.width(8.dp))
            ChatListTileDetails(
                userName = userName,
                lastMessage = lastMessage ?: "",
                timestamp = timestamp,
                unreadMessageCount = "$unreadMessageCount",
                isMessageRead = isMessageRead,
                isMessageReadByRecipient = isMessageReadByRecipient
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ChatListTilePreview() {
    ChatAppTheme {
        ChatListTile(
            imageUrl = "",
            userName = "John Doe",
            lastMessage = "Hey, how are you?",
            timestamp = "2:30 PM",
            unreadMessageCount = 2,
            isMessageRead = true,
            isMessageReadByRecipient = true,
            onClick = {}
        )
    }
}