package com.android.chatapp.features.navbar.profile.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.chatapp.core.shared.miscellaneous.NoDataFoundScreen
import com.android.chatapp.features.navbar.profile.presentation.components.UserPastStories
import com.android.chatapp.features.navbar.profile.presentation.components.UserProfileDetails

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    val textTheme = MaterialTheme.typography

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        UserProfileDetails(
            userProfileImageUrl = "https://example.com/user/profile.jpg",
            userName = "Sourashis Das",
            userEmail = "sourashisdas16@gmail.com",
            userPhone = "+1 234 567 890",
            memberSince = "Jan 2020",
            bio = "This is a sample bio for the user profile. It can span multiple lines and provide information about the user."
        )

        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Past Stories",
            style = textTheme.titleLarge,
        )
        Spacer(modifier = Modifier.height(16.dp))

        val itemCnt = 10
        if (itemCnt == 0) NoDataFoundScreen()
        else UserPastStories(
            itemsCnt = 10,
        )

        Spacer(modifier = Modifier.height(56.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}