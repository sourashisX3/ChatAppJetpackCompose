package com.android.chatapp.features.navbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.android.chatapp.R
import com.android.chatapp.core.config.navigation.DefaultAppNavigator
import com.android.chatapp.core.config.navigation.AppNavigator
import com.android.chatapp.core.config.navigation.InitNavGraph
import com.android.chatapp.core.config.navigation.Screen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navigator: AppNavigator = remember(navController) { DefaultAppNavigator(navController) }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    val navItems = listOf(
        NavItem(
            route = Screen.Home.route,
            title = "Home",
            iconRes = R.drawable.home_ic,
            matchRoutes = listOf(Screen.Home.route)
        ),
        NavItem(
            route = Screen.NewChat.route,
            title = "New Chat",
            iconRes = R.drawable.add_ic,
            matchRoutes = listOf(Screen.NewChat.route)
        ),
        NavItem(
            route = Screen.Profile.route,
            title = "Profile",
            iconRes = R.drawable.profile_ic,
            matchRoutes = listOf(Screen.Profile.route)
        )
    )

    val topLevelRoutes = navItems.flatMap { it.matchRoutes }
    val showBottomBar = topLevelRoutes.any { match ->
        currentRoute == match || currentRoute.startsWith(match)
    }

    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = showBottomBar,
                enter = slideInVertically(initialOffsetY = { it }) + fadeIn(),
                exit = slideOutVertically(targetOffsetY = { it }) + fadeOut()
            ) {
                AppNavBar(
                    currentRoute = currentRoute,
                    onNavigate = { route -> navigator.navigateTo(route) },
                    navItems = navItems
                )
            }
        }
    ) { innerPadding ->
        InitNavGraph(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}
