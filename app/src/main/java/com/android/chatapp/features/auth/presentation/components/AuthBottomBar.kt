package com.android.chatapp.features.auth.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.chatapp.core.shared.components.AppButton

@Composable
fun AuthBottomBar(
    modifier: Modifier = Modifier,
    buttonName: String,
    text: String,
    textButtonName: String,
    onButtonClick: () -> Unit,
    onTextButtonClick: () -> Unit,
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        AppButton(
            modifier = Modifier .padding(horizontal = 16.dp),
            buttonName = buttonName,
            onButtonClick = onButtonClick
        )

        TextAndButton(
            text = text,
            buttonName = textButtonName,
            onClick = onTextButtonClick
        )
    }
}