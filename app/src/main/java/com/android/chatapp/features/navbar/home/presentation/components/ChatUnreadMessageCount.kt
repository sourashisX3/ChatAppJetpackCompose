package com.android.chatapp.features.navbar.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ChatUnreadMessageCount(
    modifier: Modifier = Modifier,
    unreadMessageCount: String
) {
    val textTheme = MaterialTheme.typography
    val colorScheme = MaterialTheme.colorScheme

    fun unreadMessageCountHelper(count: String): String {
        return if (count.length > 2) "99+"
        else count
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
                color = colorScheme.surface,
                fontWeight = FontWeight.Bold
            )
        )
    }
}