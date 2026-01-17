package com.android.chatapp.core.config.navigation

import androidx.navigation.NavHostController

interface AppNavigator {
    fun navigateTo(route: String)
}

class DefaultAppNavigator(private val navController: NavHostController) : AppNavigator {
    override fun navigateTo(route: String) {
        navController.navigate(route) {
            popUpTo(navController.graph.startDestinationId) {
                //TODO: Keep default behavior
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}
