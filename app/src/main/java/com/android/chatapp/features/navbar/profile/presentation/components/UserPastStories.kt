package com.android.chatapp.features.navbar.profile.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun UserPastStories(
    itemsCnt: Int,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(itemsCnt) { _ ->
            StoryBox(
                modifier = Modifier,
                imageUrl = "https://images.unsplash.com/photo-1506744038136-46273834b3fb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c3Rvcnl8ZW58MHx8MHx8fDA%3D&w=1000&q=800",
                storyDate = "Jan 1, 2023"
            )
        }
    }
}

