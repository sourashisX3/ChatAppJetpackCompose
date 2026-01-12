package com.android.chatapp.features.auth.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "Sign In Screen")
    }
}