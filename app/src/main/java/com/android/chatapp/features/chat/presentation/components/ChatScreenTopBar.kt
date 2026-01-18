package com.android.chatapp.features.chat.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.chatapp.core.shared.components.BackButton
import com.android.chatapp.core.shared.components.CallIcon
import com.android.chatapp.core.shared.components.CommonTopBar
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
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = userName, style = textTheme.titleLarge)
                Text(
                    text = userStatus,
                    style = textTheme.bodySmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        },
        navigationIcon = { BackButton(onClick = onBackClick) },
        actions = {
            CallIcon(onClick = onCallClick)
            Spacer(modifier = Modifier.width(4.dp))
            VideoCallIcon(onClick = onVideoCallClick)
            Spacer(modifier = Modifier.width(16.dp))
        }
    )
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