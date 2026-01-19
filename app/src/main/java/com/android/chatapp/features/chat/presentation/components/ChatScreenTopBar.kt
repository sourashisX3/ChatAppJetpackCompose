package com.android.chatapp.features.chat.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.chatapp.core.shared.components.BackButton
import com.android.chatapp.core.shared.components.CallIcon
import com.android.chatapp.core.shared.components.CommonTopBar
import com.android.chatapp.core.shared.components.UserAvatar
import com.android.chatapp.core.shared.components.UserAvatarStats
import com.android.chatapp.core.shared.components.VideoCallIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreenTopBar(
    userName: String,
    userStatus: String,
    onBackClick: () -> Unit,
    onCallClick: () -> Unit,
    onVideoCallClick: () -> Unit
) {

    val textTheme = MaterialTheme.typography

    CommonTopBar(
        modifier = Modifier,
        titleContent = {
            ChatScreenTitleContent(
                userName = userName,
                userStatus = userStatus,
                imageUrl = ""
            )
        },
        navigationIcon = {
            BackButton(
                modifier = Modifier.padding(start = 16.dp),
                onClick = onBackClick
            )
        },
        actions = {
            CallIcon(onClick = onCallClick)
            Spacer(modifier = Modifier.width(4.dp))
            VideoCallIcon(onClick = onVideoCallClick)
            Spacer(modifier = Modifier.width(16.dp))
        }
    )
}

@Composable
fun ChatScreenTitleContent(
    userName: String,
    userStatus: String,
    imageUrl: String,
) {

    val textTheme = MaterialTheme.typography

    Row(
        modifier = Modifier.padding(start = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        UserAvatar(
            imageUrl = imageUrl,
            modifier = Modifier.size(50.dp),
            mode = UserAvatarStats.ONLINE
        )

        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(text = userName, style = textTheme.titleMedium)
            Text(
                text = userStatus,
                style = textTheme.bodySmall,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatScreenTopBarPreview() {
    ChatScreenTopBar(
        userName = "Sourashis Das",
        userStatus = "Online",
        onBackClick = {},
        onCallClick = {},
        onVideoCallClick = {}
    )
}