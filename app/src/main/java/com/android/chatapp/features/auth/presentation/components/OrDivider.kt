package com.android.chatapp.features.auth.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OrDivider(modifier: Modifier = Modifier) {
    val colorScheme = MaterialTheme.colorScheme
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            color = colorScheme.primary
        )
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = "Or sign in with",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = colorScheme.primary,
                fontWeight = FontWeight.Bold
            ),
        )
        HorizontalDivider(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            color = colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrDividerPreview() {
    OrDivider()
}