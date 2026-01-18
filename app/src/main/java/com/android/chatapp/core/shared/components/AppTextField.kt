package com.android.chatapp.core.shared.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.chatapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String? = null,
    leadingIcon: Painter? = null,
    onValueChange: (String) -> Unit,
    contentDescription: String? = null,
    trailingIcon: Painter? = null,
    onTrailingIconClick: (() -> Unit)? = null,
    placeholderText: String? = null,
    supportingText: String? = null,
    singleLine: Boolean = true,
    maxLines: Int = 5,
    isError: Boolean = false,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    shape: Shape = RoundedCornerShape(30.dp),
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.outline,
        disabledBorderColor = MaterialTheme.colorScheme.outline,
        errorBorderColor = MaterialTheme.colorScheme.error,
        focusedLabelColor = MaterialTheme.colorScheme.primary,
        unfocusedLabelColor = MaterialTheme.colorScheme.outline,
        disabledLabelColor = MaterialTheme.colorScheme.outline,
        errorLabelColor = MaterialTheme.colorScheme.error,
        cursorColor = MaterialTheme.colorScheme.primary,
        focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
        unfocusedLeadingIconColor = MaterialTheme.colorScheme.outline,
        disabledLeadingIconColor = MaterialTheme.colorScheme.outline,
        errorLeadingIconColor = MaterialTheme.colorScheme.error,
        focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
        unfocusedTrailingIconColor = MaterialTheme.colorScheme.outline,
        disabledTrailingIconColor = MaterialTheme.colorScheme.outline,
        errorTrailingIconColor = MaterialTheme.colorScheme.error,
        focusedPlaceholderColor = MaterialTheme.colorScheme.outline,
        unfocusedPlaceholderColor = MaterialTheme.colorScheme.outline,
        disabledPlaceholderColor = MaterialTheme.colorScheme.outline,
    ),
    interactionSource: MutableInteractionSource? = null,
) {
    val interaction = interactionSource ?: remember { MutableInteractionSource() }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label ?: "") },
        supportingText = supportingText?.let { { Text(text = it) } } ?: {},
        placeholder = placeholderText?.let { { Text(text = it) } } ?: {},
        leadingIcon = {
            leadingIcon?.let {
                Icon(
                    modifier = Modifier.size(18.dp),
                    painter = it,
                    contentDescription = contentDescription
                )
            }
        },
        trailingIcon = {
            trailingIcon?.let {
                if (onTrailingIconClick != null) {
                    IconButton(onClick = onTrailingIconClick, enabled = enabled && !readOnly) {
                        Icon(
                            modifier = Modifier.size(18.dp),
                            painter = it,
                            contentDescription = contentDescription
                        )
                    }
                } else {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        painter = it,
                        contentDescription = contentDescription
                    )
                }
            }
        },
        enabled = enabled,
        readOnly = readOnly,
        isError = isError,
        singleLine = singleLine,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        maxLines = maxLines,
        interactionSource = interaction,
        shape = shape,
        colors = colors,
    )
}

@Preview(showSystemUi = true)
@Composable
fun AppTextFieldPreview() {
    AppTextField(
        value = "",
        label = "Email",
        placeholderText = "Enter your email",
        onValueChange = {},
        trailingIcon = painterResource(R.drawable.email_ic)
    )
}
