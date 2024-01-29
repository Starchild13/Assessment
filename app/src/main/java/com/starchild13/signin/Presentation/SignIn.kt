package com.starchild13.signin.Presentation

// Importing necessary Compose UI elements and other components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.starchild13.signin.R

// Define a Composable function for the Sign-In screen
@Composable
fun SignInScreen(navController: NavHostController?) {
    // Remember state: Hold the state of username and password fields
    // 'remember' helps retain state across recompositions
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }

    // Column layout: Organizes its children in a vertical sequence
    Column(modifier = Modifier.padding(16.dp)) {
        // Text composable: Displays a text label for the screen
        Text(
            text = stringResource(R.string.sign_in),
            fontSize = 24.sp // Set the font size to 24 sp (scale-independent pixels)
        )

        Spacer(modifier = Modifier.height(16.dp)) // Adds vertical space

        // Username input: A TextField for user to enter their username
        Text(text = stringResource(R.string.username))
        TextField(
            value = username,
            onValueChange = { username = it }, // Update username state when text changes
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .background(Color.White), // Adds padding and background color to the text field
            label = { Text(stringResource(R.string.username)) } // Label inside the text field
        )

        Spacer(modifier = Modifier.height(8.dp)) // Adds vertical space

        // Password input: A TextField for user to enter their password
        Text(text = stringResource(R.string.password))
        TextField(
            value = password,
            onValueChange = { password = it }, // Update password state when text changes
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .background(Color.White), // Adds padding and background color to the text field
            visualTransformation = PasswordVisualTransformation(), // Hides password characters
            label = { Text(stringResource(R.string.password)) } // Label inside the text field
        )

        // Row layout: Organizes 'Remember me' checkbox and 'Forgot Password?' button in a row
        Row(
            modifier = Modifier.fillMaxWidth(), // Row occupies the maximum width available
            horizontalArrangement = Arrangement.SpaceBetween // Distributes space between children
        ) {
            // Checkbox for 'Remember me' functionality
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it } // Update rememberMe state when checkbox is toggled
                )
                Text(text = stringResource(R.string.remember_me))
            }

            // Button to handle 'Forgot Password?' action
            TextButton(onClick = { /* TODO: Handle forgot password action */ }) {
                Text(text = stringResource(R.string.forgot_password))
            }
        }

        Spacer(modifier = Modifier.height(16.dp)) // Adds vertical space

        // Sign in button: Triggers the sign-in process
        Button(onClick = { /* TODO: Implement sign in logic */ }) {
            Text(text = stringResource(R.string.sign_in))
        }

        Spacer(modifier = Modifier.height(16.dp)) // Adds vertical space

        // Clickable 'Sign Up' text
        val signUpText = buildAnnotatedString {
            append(stringResource(R.string.do_not_have_account) + " ")

            pushStyle(
                SpanStyle(
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                )
            )
            append(stringResource(R.string.sign_up))
            pop()
        }
        ClickableText(
            text = signUpText,
            onClick = { navController?.navigate("screen2") } // Replace with actual route
        )
    }
}


