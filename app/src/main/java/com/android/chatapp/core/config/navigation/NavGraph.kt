package com.android.chatapp.core.config.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.chatapp.features.auth.presentation.screens.SignInScreen
import com.android.chatapp.features.auth.presentation.screens.SignUpScreen
import com.android.chatapp.features.onboarding.presentation.screens.OnboardingScreen

@Composable
fun InitNavGraph(
    modifier: Modifier = Modifier,
    startDestination: String = Screen.Onboarding.route,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = Screen.Onboarding.route) { OnboardingScreen(navController = navController) }
        composable(route = Screen.SignIn.route) { SignInScreen(navController = navController) }
        composable(route = Screen.SignUp.route) { SignUpScreen(navController = navController) }
    }
}