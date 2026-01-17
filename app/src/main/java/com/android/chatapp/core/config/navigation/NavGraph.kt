package com.android.chatapp.core.config.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.chatapp.features.auth.presentation.screens.SignInScreen
import com.android.chatapp.features.auth.presentation.screens.SignUpScreen
import com.android.chatapp.features.chat.presentation.screens.ChatScreen
import com.android.chatapp.features.navbar.add_new_chat.presentation.screens.CreateNewChatBottomSheet
import com.android.chatapp.features.navbar.home.presentation.screens.HomeScreen
import com.android.chatapp.features.navbar.profile.presentation.screens.ProfileScreen
import com.android.chatapp.features.onboarding.presentation.screens.OnboardingScreen

@Composable
fun InitNavGraph(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    startDestination: String = Screen.Onboarding.route,
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = Screen.Onboarding.route) { OnboardingScreen(navController = navController) }
        composable(route = Screen.SignIn.route) { SignInScreen(navController = navController) }
        composable(route = Screen.SignUp.route) { SignUpScreen(navController = navController) }
        composable(route = Screen.Chat.route) { ChatScreen(navController = navController) }

        // --- Nav Bar Screens ---
        composable(route = Screen.Home.route) { HomeScreen(navController = navController) }
        composable(route = Screen.NewChat.route) { CreateNewChatBottomSheet() }
        composable(route = Screen.Profile.route) { ProfileScreen() }
    }
}