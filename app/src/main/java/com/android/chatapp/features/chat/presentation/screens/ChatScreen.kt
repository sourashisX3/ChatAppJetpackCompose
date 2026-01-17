package com.android.chatapp.features.chat.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    navController : NavHostController
) {
    Text(text = "Chat Screen", modifier = modifier)
}