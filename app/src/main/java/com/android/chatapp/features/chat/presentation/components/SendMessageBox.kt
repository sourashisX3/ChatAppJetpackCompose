package com.android.chatapp.features.chat.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.chatapp.R
import com.android.chatapp.core.shared.components.AppTextField
import com.android.chatapp.core.shared.components.SendMessageButton

@Composable
fun SendMessageBox(onSend: (String) -> Unit = {}) {
    var message by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AppTextField(
            value = message,
            onValueChange = { message = it },
            label = "Message",
            placeholderText = "Type a message...",
            leadingIcon = painterResource(R.drawable.comment_ic),
            modifier = Modifier.weight(1f),
            singleLine = false,
            maxLines = 6
        )

        SendMessageButton(
            onClick = {
                if (message.isNotBlank()) {
                    onSend(message.trim())
                    message = ""
                }
            }, modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SendMessageBoxPreview() {
    SendMessageBox()
}