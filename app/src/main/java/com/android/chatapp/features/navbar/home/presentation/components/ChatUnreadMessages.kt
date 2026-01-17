package com.android.chatapp.features.navbar.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.chatapp.R
import com.android.chatapp.ui.theme.success

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
    val textStyle =
        if (isMessageRead) textTheme.bodyMedium else textTheme.bodyMedium.copy(
            fontWeight = FontWeight.Bold,
            color = colorScheme.primary
        )

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
            style = textStyle
        )
    }
}