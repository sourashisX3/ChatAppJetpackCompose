package com.android.chatapp.features.navbar.profile.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.android.chatapp.R

@Composable
fun StoryBox(
    modifier: Modifier = Modifier,
    imageUrl: String,
    storyDate: String,
) {

    val colorScheme = MaterialTheme.colorScheme
    val textTheme = MaterialTheme.typography
    val cornerRadius = 16.dp

    Box(
        modifier = modifier
            .height(200.dp)
            .width(150.dp),
    ) {
        AsyncImage(
            modifier = modifier
                .height(200.dp)
                .width(150.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(cornerRadius)
                )
                .clip(RoundedCornerShape(cornerRadius)),
            model = imageUrl,
            placeholder = painterResource(R.drawable.picture_ic),
            error = painterResource(R.drawable.picture_ic),
            contentScale = ContentScale.Crop,
            contentDescription = "User Story Image"
        )

        DateGradientOverlay(
            modifier = Modifier.align(Alignment.BottomCenter),
            storyDate = storyDate,
        )

    }
}

@Composable
fun DateGradientOverlay(
    modifier: Modifier = Modifier,
    storyDate: String,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black.copy(alpha = 0.6f)
                    )
                )
            )
    ) {
        Text(
            text = storyDate,
            modifier = Modifier
                .padding(start = 8.dp, bottom = 8.dp)
                .align(Alignment.BottomStart),
            style = MaterialTheme.typography.titleMedium,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StoryBoxPreview() {
    StoryBox(
        imageUrl = "https://images.unsplash.com/photo-1506744038136-46273834b3fb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c3Rvcnl8ZW58MHx8MHx8fDA%3D&w=1000&q=800",
        storyDate = "Jan 1, 2023"
    )
}