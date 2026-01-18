package com.android.chatapp.features.chat.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.chatapp.R
import com.android.chatapp.core.shared.components.AppTextField
import com.android.chatapp.core.shared.components.SendMessageButton

@Composable
fun SendMessageBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            AppTextField(
                value = "",
                onValueChange = {},
                label = "Type a message...",
                placeholderText = "Type a message...",
                leadingIcon = painterResource(R.drawable.comment_ic),
                modifier = Modifier.weight(3.5f)
            )
            Spacer(modifier = Modifier.padding(end = 8.dp))
            SendMessageButton(
                onClick = {}, modifier = Modifier
                    .padding(vertical = 4.dp)
                    .weight(0.65f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SendMessageBoxPreview() {
    SendMessageBox()
}