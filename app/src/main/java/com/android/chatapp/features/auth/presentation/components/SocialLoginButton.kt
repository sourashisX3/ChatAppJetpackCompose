package com.android.chatapp.features.auth.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.android.chatapp.core.shared.components.AppButton

@Composable
fun SocialLoginButton(
    modifier: Modifier = Modifier,
    buttonName: String,
    icon: Painter,
    onButtonClick: () -> Unit
) {
    AppButton(
        modifier = modifier,
        buttonName = buttonName,
        leadingIcon = {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = icon,
                contentDescription = buttonName,
                tint = Color.Unspecified
            )
        },
        onButtonClick = onButtonClick,
        outlined = true
    )
}