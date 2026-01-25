package com.android.chatapp.features.navbar.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.android.chatapp.R

@Composable
fun UserProfilesAndNames(
    modifier: Modifier = Modifier,
    userName: String,
    isAddStory: Boolean = false,
    onClick: () -> Unit = { }
) {
    val textTheme = MaterialTheme.typography
    val colorScheme = MaterialTheme.colorScheme
    val context = LocalContext.current
    val density = LocalDensity.current
    val imageDp = 64.dp
    val imagePx = with(density) { imageDp.roundToPx() }
    val url = "https://example.com/user/profile.jpg"

    val request = remember(url, imagePx) {
        ImageRequest.Builder(context)
            .data(url)
            .crossfade(true)
            .size(imagePx)
            .build()
    }

    Column(
        modifier = modifier
            .height(100.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .clickable(onClick = onClick),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.BottomEnd
        ) {
            val imageModifier = Modifier
                .size(imageDp)
                .clip(CircleShape)
                .border(width = 2.dp, color = colorScheme.primary, shape = CircleShape)
                .background(color = colorScheme.primary.copy(alpha = 0.5f))

            AsyncImage(
                model = request,
                contentDescription = "User Profile",
                placeholder = painterResource(R.drawable.profile_placeholder),
                error = painterResource(R.drawable.profile_placeholder),
                contentScale = ContentScale.Crop,
                modifier = imageModifier
            )

            // Add icon for "Add Story"
            if (isAddStory) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .offset(x = (-2).dp, y = (-2).dp)
                        .clip(CircleShape)
                        .background(colorScheme.primary)
                        .border(width = 2.dp, color = colorScheme.surface, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.add_ic),
                        contentDescription = "Add Story",
                        modifier = Modifier.size(12.dp),
                        tint = colorScheme.surface
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = userName, style = textTheme.bodyMedium.copy(fontWeight = FontWeight.Bold))
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfilesAndNamesPreview() {
    UserProfilesAndNames(userName = "John Doe")
}

@Preview(showBackground = true)
@Composable
fun AddStoryPreview() {
    UserProfilesAndNames(userName = "Add Story", isAddStory = true)
}
