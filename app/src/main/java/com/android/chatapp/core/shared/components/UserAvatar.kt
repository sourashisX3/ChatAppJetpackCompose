package com.android.chatapp.core.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.android.chatapp.R
import com.android.chatapp.ui.theme.success

enum class UserAvatarStats {
    NONE,
    EDITABLE,
    ONLINE,
    OFFLINE,
    AWAY,
    BUSY,
}

@Composable
fun UserAvatar(
    modifier: Modifier = Modifier,
    imageUrl: String,
    mode: UserAvatarStats = UserAvatarStats.NONE
) {

    val colorScheme = MaterialTheme.colorScheme
    val context = LocalContext.current
    val density = LocalDensity.current
    val imageDp = 64.dp
    val imagePx = with(density) { imageDp.roundToPx() }

    val request = remember(imageUrl, imagePx) {
        ImageRequest.Builder(context)
            .data(imageUrl)
            .crossfade(true)
            .size(imagePx)
            .build()
    }

    val boxModifier = modifier.size(imageDp)

    val imageModifier = modifier
        .size(imageDp)
        .clip(CircleShape)
        .background(color = colorScheme.primary.copy(alpha = 0.5f))

    Box(
        modifier = boxModifier
    ) {
        AsyncImage(
            model = request,
            contentDescription = "User Profile",
            placeholder = painterResource(R.drawable.profile_placeholder),
            error = painterResource(R.drawable.profile_placeholder),
            contentScale = ContentScale.Crop,
            modifier = imageModifier
        )
        when (mode) {
            UserAvatarStats.ONLINE -> {
                OnlineDot(
                    modifier = Modifier
                        .align(androidx.compose.ui.Alignment.BottomEnd)
                )
            }

            UserAvatarStats.OFFLINE -> {
                OfflineDot(
                    modifier = Modifier
                        .align(androidx.compose.ui.Alignment.BottomEnd)
                )
            }

            else -> {
                //TODO: No status dot
            }
        }
    }
}

@Composable
fun OnlineDot(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(16.dp)
            .border(width = 2.dp, color = MaterialTheme.colorScheme.background, shape = CircleShape)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.success)
    )
}

@Composable
fun OfflineDot(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(16.dp)
            .border(width = 2.dp, color = MaterialTheme.colorScheme.background, shape = CircleShape)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.error)
    )
}

@Preview(showBackground = true)
@Composable
fun UserAvatarPreview() {
    UserAvatar(imageUrl = "https://example.com/user/profile.jpg")
}