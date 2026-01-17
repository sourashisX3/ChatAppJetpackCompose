package com.android.chatapp.core.shared.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.chatapp.R

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    buttonName: String,
    buttonTextStyle: TextStyle? = null,
    onButtonClick: () -> Unit,
    buttonColor: Color? = null,
    buttonHeight: Dp? = 56.dp,
    buttonWidth: Dp? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    outlined: Boolean = false,
    borderStroke: BorderStroke? = null,
    cornerRadius: Dp? = 30.dp,
) {
    val shape = RoundedCornerShape(cornerRadius ?: 8.dp)
    val effectiveButtonColor = buttonColor ?: MaterialTheme.colorScheme.primary
    val contentColor = if (outlined) effectiveButtonColor else MaterialTheme.colorScheme.onPrimary

    val colors = if (outlined) {
        ButtonDefaults.outlinedButtonColors(contentColor = contentColor)
    } else {
        ButtonDefaults.buttonColors(
            containerColor = effectiveButtonColor,
            contentColor = contentColor
        )
    }

    val sizeModifier = if (buttonWidth != null) {
        modifier
            .height(buttonHeight ?: Dp.Unspecified)
            .width(buttonWidth)
    } else {
        modifier
            .height(buttonHeight ?: Dp.Unspecified)
            .fillMaxWidth()
    }

    if (outlined) {
        OutlinedButton(
            modifier = sizeModifier,
            onClick = onButtonClick,
            shape = shape,
            border = borderStroke ?: BorderStroke(1.dp, effectiveButtonColor),
            colors = colors
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                if (leadingIcon != null) {
                    leadingIcon()
                    Spacer(modifier = Modifier.width(8.dp))
                }

                Text(
                    text = buttonName,
                    style = buttonTextStyle
                        ?: MaterialTheme.typography.labelLarge.copy(color = contentColor)
                )

                if (trailingIcon != null) {
                    Spacer(modifier = Modifier.width(8.dp))
                    trailingIcon()
                }
            }
        }
    } else {
        Button(
            modifier = sizeModifier,
            onClick = onButtonClick,
            shape = shape,
            colors = colors,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                if (leadingIcon != null) {
                    leadingIcon()
                    Spacer(modifier = Modifier.width(8.dp))
                }

                Text(
                    text = buttonName,
                    style = buttonTextStyle
                        ?: MaterialTheme.typography.labelLarge.copy(color = MaterialTheme.colorScheme.surface)
                )

                if (trailingIcon != null) {
                    Spacer(modifier = Modifier.width(8.dp))
                    trailingIcon()
                }
            }
        }
    }
}