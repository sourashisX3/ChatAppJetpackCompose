package com.android.chatapp.features.navbar.home.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android.chatapp.features.auth.presentation.components.OrDivider

@Composable
fun EndChatListMessage(modifier: Modifier = Modifier) {
    OrDivider(
        modifier = modifier,
        text = "You're all caught up"
    )
}