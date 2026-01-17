package com.android.chatapp.features.navbar.profile.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.chatapp.core.shared.components.UserAvatar

@Composable
fun UserProfileDetails(
    userProfileImageUrl: String,
    userName: String,
    userEmail: String,
    userPhone: String,
    memberSince: String,
    bio: String,
) {
    val textTheme = MaterialTheme.typography
    val colorScheme = MaterialTheme.colorScheme
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UserAvatar(
            modifier = Modifier.size(100.dp),
            imageUrl = userProfileImageUrl,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = userName,
            style = textTheme.headlineMedium,
        )
        Text(
            text = userEmail,
            style = textTheme.bodyMedium,
        )
        Text(
            text = userPhone,
            style = textTheme.bodyMedium,
        )
        Text(
            text = "Member since $memberSince",
            style = textTheme.titleMedium,
            color = colorScheme.primary
        )
        Spacer(modifier = Modifier.height(24.dp))
        ProfileBioBox(text = bio)
    }
}