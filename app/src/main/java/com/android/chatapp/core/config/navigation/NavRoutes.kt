package com.android.chatapp.core.config.navigation

sealed class Screen(val route : String) {
    object SignIn : Screen(SIGN_IN)
    object SignUp : Screen(SIGN_UP)
    object Onboarding : Screen(ONBOARDING)
    object Home : Screen(HOME)
    object Chat : Screen(CHAT)
    object NewChat : Screen(NEW_CHAT)
    object Profile : Screen(PROFILE)
    object Settings : Screen(SETTINGS)
}