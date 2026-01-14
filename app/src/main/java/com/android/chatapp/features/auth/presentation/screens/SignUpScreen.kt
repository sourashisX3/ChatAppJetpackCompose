package com.android.chatapp.features.auth.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.chatapp.R
import com.android.chatapp.core.config.navigation.Screen
import com.android.chatapp.core.shared.components.AppTextField
import com.android.chatapp.core.shared.components.BackButton
import com.android.chatapp.features.auth.presentation.components.AuthBottomBar
import com.android.chatapp.features.auth.presentation.components.AuthTopBar

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val theme = MaterialTheme
    val textTheme = theme.typography
    val scrollState = rememberScrollState()
    val nameController = remember { mutableStateOf("") }
    val phoneController = remember { mutableStateOf("") }
    val emailController = remember { mutableStateOf("") }
    val passwordController = remember { mutableStateOf("") }
    val confirmPasswordController = remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var confirmPasswordVisible by rememberSaveable { mutableStateOf(false) }

    // --- UI ---
    Scaffold(
        topBar = { AuthTopBar(onClick = { navController.popBackStack() }) },
        bottomBar = {
            AuthBottomBar(
                buttonName = "Sign Up",
                text = "Already have an account?",
                textButtonName = "Sign In",
                onButtonClick = { /* TODO: Sign Up action */ },
                onTextButtonClick = { navController.navigate(Screen.SignIn.route) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState)
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.padding(top = 24.dp))
            Text(
                text = "Let's join with us!",
                style = textTheme.titleLarge
            )
            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
            Spacer(modifier = Modifier.padding(top = 36.dp))

            // --- Sign Up Form ---
            AppTextField(
                modifier = Modifier,
                value = nameController.value,
                label = "Full Name",
                placeholderText = "Enter your full name",
                leadingIcon = painterResource(R.drawable.profile_ic),
                onValueChange = { nameController.value = it },
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            AppTextField(
                modifier = Modifier,
                value = phoneController.value,
                label = "Phone Number",
                placeholderText = "Enter your phone number",
                leadingIcon = painterResource(R.drawable.phone_ic),
                onValueChange = { phoneController.value = it },
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            AppTextField(
                modifier = Modifier,
                value = emailController.value,
                label = "Email",
                placeholderText = "Enter your email",
                leadingIcon = painterResource(R.drawable.email_ic),
                onValueChange = { emailController.value = it },
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            AppTextField(
                modifier = Modifier,
                value = passwordController.value,
                label = "Password",
                placeholderText = "Enter your password",
                leadingIcon = painterResource(R.drawable.lock_ic),
                trailingIcon = painterResource(
                    if (passwordVisible) R.drawable.eye_ic else R.drawable.eye_crossed_ic
                ),
                onTrailingIconClick = { passwordVisible = !passwordVisible },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(
                    mask = '*'
                ),
                onValueChange = { passwordController.value = it },
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            AppTextField(
                modifier = Modifier,
                value = confirmPasswordController.value,
                label = "Confirm Password",
                placeholderText = "Re-enter your password",
                leadingIcon = painterResource(R.drawable.lock_ic),
                trailingIcon = painterResource(
                    if (confirmPasswordVisible) R.drawable.eye_ic else R.drawable.eye_crossed_ic
                ),
                onTrailingIconClick = { confirmPasswordVisible = !confirmPasswordVisible },
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(
                    mask = '*'
                ),
                onValueChange = { confirmPasswordController.value = it },
            )
            Spacer(modifier = Modifier.padding(bottom = 80.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(navController = NavHostController(LocalContext.current))
}