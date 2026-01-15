package com.android.chatapp.core.shared.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.chatapp.R

@Composable
fun AppIconButton(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    iconPainter: Painter,
    size: Dp = 24.dp,
    iconSize: Dp = 18.dp,
    borderWidth: Dp = 1.dp,
    showBorder: Boolean = true,
    enforceMinTouchTarget: Boolean = true,
    onClick: () -> Unit
) {
    val color = MaterialTheme.colorScheme.primary

    val finalSize = if (enforceMinTouchTarget) {
        if (size < 36.dp) 36.dp else size
    } else size

    val interactionSource = remember { MutableInteractionSource() }
    val clickableModifier = Modifier
        .size(finalSize)
        .clip(CircleShape)
        .then(
            if (showBorder) Modifier.border(
                width = borderWidth,
                color = color,
                shape = CircleShape
            ) else Modifier
        )
        .clickable(
            interactionSource = interactionSource,
            onClick = onClick
        )

    val content: @Composable () -> Unit = {
        Box(
            modifier = modifier.then(clickableModifier),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(iconSize),
                painter = iconPainter,
                tint = color,
                contentDescription = contentDescription
            )
        }
    }

    content()
}

@Composable
fun BackButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    AppIconButton(
        modifier = modifier,
        contentDescription = "Back",
        iconPainter = painterResource(R.drawable.arrow_back_ic),
        onClick = onClick
    )
}

@Composable
fun SearchIcon(modifier: Modifier = Modifier) {
    AppIconButton(
        modifier = modifier,
        contentDescription = "Search",
        iconPainter = painterResource(R.drawable.search_ic),
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun AppIconButtonPreview() {
    AppIconButton(
        modifier = Modifier,
        contentDescription = "Back",
        iconPainter = painterResource(R.drawable.arrow_back_ic),
        size = 24.dp,
        iconSize = 18.dp,
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun BackButtonPreview() {
    BackButton(onClick = {})
}

@Preview(showBackground = true)
@Composable
fun SearchIconPreview() {
    SearchIcon()
}
