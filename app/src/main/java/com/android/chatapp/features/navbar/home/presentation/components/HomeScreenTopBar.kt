package com.android.chatapp.features.navbar.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.android.chatapp.R
import com.android.chatapp.core.shared.components.SearchIcon

@Composable
fun HomeScreenTopBar(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit
) {
    val textTheme = MaterialTheme.typography
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = stringResource(R.string.app_name), style = textTheme.displaySmall)
        SearchIcon(onClick = onSearchClick)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenTopBarPreview() {
    HomeScreenTopBar(onSearchClick = {})
}