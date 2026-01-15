package com.android.chatapp.features.navbar.home.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.chatapp.core.shared.components.UserAvatar

@Composable
fun ChatListTile(
    modifier: Modifier = Modifier,
    imageUrl: String,
    userName: String,
    lastMessage: String? = null,
    timestamp: String? = null,
    unreadMessageCount: Int = 0
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            UserAvatar()
            Spacer(modifier = Modifier.weight(1f))
            Text(text = userName)
        }
    }
}