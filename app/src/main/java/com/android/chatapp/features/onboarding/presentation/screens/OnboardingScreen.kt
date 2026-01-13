@file:Suppress("DEPRECATION")

package com.android.chatapp.features.onboarding.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.android.chatapp.R
import com.android.chatapp.core.config.navigation.Screen
import com.android.chatapp.core.shared.components.AppButton

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.connect_with_us)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    val scrollState = rememberScrollState()
    val textTheme = MaterialTheme.typography

    // --- UI ---
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier.size(300.dp)
        )

        Spacer(modifier = Modifier.size(16.dp))

        Text(
            text = "Welcome to the Onboarding Screen",
            style = textTheme.titleLarge,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            style = textTheme.bodyMedium,
            textAlign = TextAlign.Center,
        )

        AppButton(
            modifier = Modifier
                .padding(top = 24.dp, bottom = 16.dp),
            buttonName = "Sign in",
            onButtonClick = { navController.navigate(Screen.SignIn.route) },
        )

        AppButton(
            modifier = Modifier
                .padding(bottom = 32.dp),
            buttonName = "Create an account",
            onButtonClick = { /* TODO: Handle button click */ },
            outlined = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(navController = NavHostController(context = LocalContext.current))
}