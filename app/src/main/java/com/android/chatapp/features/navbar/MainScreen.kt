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
import com.android.chatapp.core.constants.StringConstants
import com.android.chatapp.core.shared.components.AppTopBar
import com.android.chatapp.features.chat.presentation.components.ChatScreenTopBar

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
            selectedIconRes = R.drawable.home_filled_ic,
            matchRoutes = listOf(Screen.Home.route)
        ),
        NavItem(
            route = Screen.NewChat.route,
            title = "New Chat",
            iconRes = R.drawable.add_chat_ic,
            selectedIconRes = R.drawable.add_chat_filled_ic,
            matchRoutes = listOf(Screen.NewChat.route)
        ),
        NavItem(
            route = Screen.Profile.route,
            title = "Profile",
            iconRes = R.drawable.profile_ic,
            selectedIconRes = R.drawable.profile_filled_ic,
            matchRoutes = listOf(Screen.Profile.route)
        )
    )

    // --- Main Scaffold ---

    fun showTopBar(): Boolean {
        val topBarRoutes = listOf(
            Screen.Home.route,
            Screen.Profile.route,
            Screen.NewChat.route,
            Screen.Chat.route
        )
        return topBarRoutes.any { route ->
            currentRoute == route || currentRoute.startsWith(route)
        }
    }

    fun topBarHelper(
        chatScreenUserName: String,
        chatScreenUserStatus: String,
        onSearchClick: () -> Unit,
        onNotificationClick: () -> Unit,
        onMoreOptionsClick: () -> Unit,
        onCallClick: () -> Unit,
        onVideoCallClick: () -> Unit
    ): @Composable () -> Unit {
        return when (currentRoute) {
            Screen.Home.route -> {
                {
                    AppTopBar(
                        title = StringConstants.APP_NAME,
                        subtitle = "Welcome Back! Sourashis",
                        isSearchIconVisible = true,
                        isNewNotification = true,
                        onSearchClick = onSearchClick,
                        onNotificationClick = onNotificationClick
                    )
                }
            }

            Screen.NewChat.route -> {
                {
                    AppTopBar(
                        title = "New Chat",
                        isNotificationIconVisible = true,
                        onNotificationClick = onNotificationClick
                    )
                }
            }

            Screen.Profile.route -> {
                {
                    AppTopBar(
                        title = "Profile",
                        isMoreIconVisible = true,
                        onMoreOptionsClick = onMoreOptionsClick,
                    )
                }
            }

            Screen.Chat.route -> {
                {
                    ChatScreenTopBar(
                        userName = chatScreenUserName,
                        userStatus = chatScreenUserStatus,
                        onBackClick = { navController.popBackStack() },
                        onCallClick = onCallClick,
                        onVideoCallClick = onVideoCallClick
                    )
                }
            }

            else -> {
                { AppTopBar(title = StringConstants.APP_NAME) }
            }
        }
    }

    val topLevelRoutes = navItems.flatMap { it.matchRoutes }
    val showBottomBar = topLevelRoutes.any { match ->
        currentRoute == match || currentRoute.startsWith(match)
    }

    val showTopBar = showTopBar()

    /*val topBarTitle =
        if (navItems.firstOrNull()?.route == currentRoute) StringConstants.APP_NAME
        else navItems.find { it.route == currentRoute }?.title ?: StringConstants.APP_NAME*/

    Scaffold(
        topBar = {
            AnimatedVisibility(
                visible = showTopBar,
                enter = slideInVertically(initialOffsetY = { -it }) + fadeIn(),
                exit = slideOutVertically(targetOffsetY = { -it }) + fadeOut()
            ) {
                topBarHelper(
                    chatScreenUserName = "John Doe",
                    chatScreenUserStatus = "Online",
                    onSearchClick = { /*TODO*/ },
                    onNotificationClick = { /*TODO*/ },
                    onMoreOptionsClick = { /*TODO*/ },
                    onCallClick = { /*TODO*/ },
                    onVideoCallClick = { /*TODO*/ }
                ).invoke()
                /*AppTopBar(
                    title = topBarTitle,
                    isMoreIconVisible = currentRoute == Screen.Profile.route,
                    isSearchIconVisible = currentRoute == Screen.Home.route,
                    isNewNotification = currentRoute == Screen.Home.route,
                )*/
            }
        },
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
