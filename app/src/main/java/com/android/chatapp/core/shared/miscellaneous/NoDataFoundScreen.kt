@file:Suppress("DEPRECATION")

package com.android.chatapp.core.shared.miscellaneous

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.android.chatapp.R

@Composable
fun NoDataFoundScreen(modifier: Modifier = Modifier) {

    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.no_result_found)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    val textTheme = MaterialTheme.typography

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier.size(300.dp)
        )

        Text(text = "No Data Found", style = textTheme.titleLarge)
        Text(text = "Please try again later.", style = textTheme.bodyMedium)
    }
}

@Preview(showSystemUi = true)
@Composable
fun NoDataFoundScreenPreview() {
    NoDataFoundScreen()
}