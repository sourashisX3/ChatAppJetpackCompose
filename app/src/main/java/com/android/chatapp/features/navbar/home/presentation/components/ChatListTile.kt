package com.android.chatapp.features.navbar.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.chatapp.R
import com.android.chatapp.core.shared.components.UserAvatar
import com.android.chatapp.ui.theme.ChatAppTheme
import com.android.chatapp.ui.theme.success

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
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp)
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            UserAvatar(imageUrl = imageUrl)
            Spacer(modifier = Modifier.width(8.dp))
            ChatDetails(
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

@Composable
fun ChatDetails(
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

@Composable
fun ChatUnreadMessages(
    modifier: Modifier = Modifier,
    isMessageRead: Boolean,
    lastMessage: String,
    isMessageReadByRecipient: Boolean
) {
    val textTheme = MaterialTheme.typography
    val colorScheme = MaterialTheme.colorScheme
    val iconTint =
        if (isMessageReadByRecipient) colorScheme.success else colorScheme.onSurfaceVariant

    if (isMessageRead)
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.tick_ic),
                contentDescription = "Read Icon",
                modifier = Modifier.size(12.dp),
                colorFilter = ColorFilter.tint(iconTint)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = lastMessage,
                maxLines = 1,
                style = textTheme.bodyMedium
            )
        }
    else
        Text(
            text = lastMessage,
            maxLines = 1,
            style = textTheme.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                color = colorScheme.primary
            )
        )
}

@Composable
fun ChatUnreadMessageCount(
    modifier: Modifier = Modifier,
    unreadMessageCount: String
) {
    val textTheme = MaterialTheme.typography
    val colorScheme = MaterialTheme.colorScheme

    fun unreadMessageCountHelper(count: String): String {
        return if (count.length > 2) {
            "99+"
        } else {
            count
        }
    }

    Box(
        modifier = modifier
            .size(28.dp)
            .clip(CircleShape)
            .background(colorScheme.primary),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = unreadMessageCountHelper(unreadMessageCount),
            maxLines = 1,
            style = textTheme.bodySmall.copy(
                color = colorScheme.onPrimary,
                fontWeight = FontWeight.Bold
            )
        )
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
            isMessageReadByRecipient = true // show the green tick in preview
        )
    }
}