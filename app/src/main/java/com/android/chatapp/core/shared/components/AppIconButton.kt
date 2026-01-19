package com.android.chatapp.core.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
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
    val colorScheme = MaterialTheme.colorScheme
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
                color = color.copy(alpha = 0.5f),
                shape = CircleShape
            ) else Modifier
        )
        .clickable(
            interactionSource = interactionSource,
            onClick = onClick
        )

    val content: @Composable () -> Unit = {
        Box(
            modifier = modifier
                .background(color = color.copy(alpha = 0.15f), shape = CircleShape)
                .then(clickableModifier),
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
fun SearchIcon(modifier: Modifier = Modifier, onClick: () -> Unit) {
    AppIconButton(
        modifier = modifier,
        contentDescription = "Search",
        iconPainter = painterResource(R.drawable.search_ic),
        onClick = onClick
    )
}

@Composable
fun ThreeDotIcon(modifier: Modifier = Modifier, onClick: () -> Unit) {
    AppIconButton(
        modifier = modifier,
        contentDescription = "More Options",
        iconPainter = painterResource(R.drawable.three_dot_ic),
        onClick = onClick
    )
}

@Composable
fun NotificationIcon(
    modifier: Modifier = Modifier,
    isNewNotification: Boolean = false,
    onClick: () -> Unit
) {
    Box {
        AppIconButton(
            modifier = modifier,
            contentDescription = "Notifications",
            iconPainter = painterResource(R.drawable.notificaion_bell_ic),
            onClick = onClick
        )
        if (isNewNotification)
            RedDotIndicator(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 9.dp, top = 8.dp)
            )
    }
}

@Composable
fun CrossIcon(modifier: Modifier = Modifier, onClick: () -> Unit) {
    AppIconButton(
        modifier = modifier,
        contentDescription = "Close",
        iconPainter = painterResource(R.drawable.cross_ic),
        onClick = onClick
    )
}

@Composable
fun CallIcon(modifier: Modifier = Modifier, onClick: () -> Unit) {
    AppIconButton(
        modifier = modifier,
        contentDescription = "Call",
        iconPainter = painterResource(R.drawable.phone_call_ic),
        onClick = onClick
    )
}

@Composable
fun VideoCallIcon(modifier: Modifier = Modifier, onClick: () -> Unit) {
    AppIconButton(
        modifier = modifier,
        contentDescription = "Video Call",
        iconPainter = painterResource(R.drawable.video_call_ic),
        onClick = onClick
    )
}

@Composable
fun PencilEditIcon(modifier: Modifier = Modifier, onClick: () -> Unit) {
    AppIconButton(
        modifier = modifier,
        contentDescription = "Edit",
        iconPainter = painterResource(R.drawable.pencil_edit_ic),
        onClick = onClick
    )
}

@Composable
fun SendMessageButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    AppIconButton(
        modifier = modifier,
        contentDescription = "Send Message",
        iconPainter = painterResource(R.drawable.paper_plane_ic),
        size = 56.dp,
        iconSize = 24.dp,
        onClick = onClick
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

@Composable
fun RedDotIndicator(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(8.dp)
            .background(color = MaterialTheme.colorScheme.error, shape = CircleShape)
    )
}


// --- icon Previews ---


@Preview(showBackground = true)
@Composable
fun BackButtonPreview() {
    BackButton(onClick = {})
}

@Preview(showBackground = true)
@Composable
fun SearchIconPreview() {
    SearchIcon(onClick = {})
}

@Preview(showBackground = true)
@Composable
fun NotificationIconPreview() {
    NotificationIcon(onClick = {})
}

@Preview(showBackground = true)
@Composable
fun ThreeDotIconPreview() {
    ThreeDotIcon(onClick = {})
}

@Preview(showBackground = true)
@Composable
fun CrossIconPreview() {
    CrossIcon(onClick = {})
}

@Preview(showBackground = true)
@Composable
fun CallIconPreview() {
    CallIcon(onClick = {})
}

@Preview(showBackground = true)
@Composable
fun VideoCallIconPreview() {
    VideoCallIcon(onClick = {})
}

@Preview(showBackground = true)
@Composable
fun SendMessageButtonPreview() {
    SendMessageButton(onClick = {})
}

@Preview(showBackground = true)
@Composable
fun PencilEditIconPreview() {
    PencilEditIcon(onClick = {})
}