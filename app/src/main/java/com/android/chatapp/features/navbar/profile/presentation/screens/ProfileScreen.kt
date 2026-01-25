package com.android.chatapp.features.navbar.profile.presentation.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.chatapp.core.shared.miscellaneous.NoDataFoundScreen
import com.android.chatapp.features.navbar.profile.presentation.components.StoryBox
import com.android.chatapp.features.navbar.profile.presentation.components.UserProfileDetails

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    val textTheme = MaterialTheme.typography
    val gridState = rememberLazyGridState()

    // Calculate scroll-based animations
    val scrollOffset by remember {
        derivedStateOf {
            gridState.firstVisibleItemIndex * 100f + gridState.firstVisibleItemScrollOffset
        }
    }

    // Animate profile header scale and alpha based on scroll
    val headerScale by animateFloatAsState(
        targetValue = if (scrollOffset > 50f) 0.85f else 1f,
        animationSpec = tween(durationMillis = 300),
        label = "headerScale"
    )

    val headerAlpha by animateFloatAsState(
        targetValue = if (scrollOffset > 200f) 0.7f else 1f,
        animationSpec = tween(durationMillis = 300),
        label = "headerAlpha"
    )

    val itemCnt = 10

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        state = gridState,
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Header section with animation
        item(span = { GridItemSpan(2) }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .scale(headerScale)
                    .alpha(headerAlpha),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                UserProfileDetails(
                    userProfileImageUrl = "https://example.com/user/profile.jpg",
                    userName = "Sourashis Das",
                    userEmail = "sourashisdas16@gmail.com",
                    userPhone = "+1 234 567 890",
                    memberSince = "Jan 2020",
                    bio = "This is a sample bio for the user profile. It can span multiple lines and provide information about the user."
                )
            }
        }

        // Spacer
        item(span = { GridItemSpan(2) }) {
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Past Stories Title
        item(span = { GridItemSpan(2) }) {
            Text(
                text = "Past Stories",
                style = textTheme.titleLarge,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        // Stories Grid or No Data
        if (itemCnt == 0) {
            item(span = { GridItemSpan(2) }) {
                NoDataFoundScreen()
            }
        } else {
            items(itemCnt, span = { GridItemSpan(1) }) { _ ->
                StoryBox(
                    modifier = Modifier,
                    imageUrl = "https://images.unsplash.com/photo-1506744038136-46273834b3fb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c3Rvcnl8ZW58MHx8MHx8fDA%3D&w=1000&q=800",
                    storyDate = "Jan 1, 2023"
                )
            }
        }

        // Bottom Spacer
        item(span = { GridItemSpan(2) }) {
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}

