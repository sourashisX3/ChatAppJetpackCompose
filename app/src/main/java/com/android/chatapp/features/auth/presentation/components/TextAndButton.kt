package com.android.chatapp.features.auth.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextAndButton(
    modifier: Modifier = Modifier,
    text: String,
    buttonName: String,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = text, style = MaterialTheme.typography.bodyMedium)
        TextButton(
            onClick = onClick,
            content = {
                Text(
                    text = buttonName, style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun TextAndButtonPreview() {
    TextAndButton(
        text = "Don't have an account?",
        buttonName = "Sign Up",
        onClick = {}
    )
}