
package com.starchild13.signin.Presentation

// Importing necessary Compose UI elements and other components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.starchild13.signin.R

// Define a Composable function for the Account Creation screen
@Composable
fun CreateScreen(navController: NavController) {
    // State variables for username, password, and email fields
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    // Column layout: Organizes its children in a vertical sequence
    Column(modifier = Modifier.padding(16.dp)) {
        // Heading text for the account creation screen
        Text(
            text = stringResource(R.string.create_account),
            fontSize = 24.sp // Setting the font size for the heading
        )

        Spacer(modifier = Modifier.height(16.dp)) // Adds vertical spacing

        // Username input field
        Text(text = stringResource(R.string.username))
        TextField(
            value = username,
            onValueChange = { username = it },
            modifier = Modifier
                .padding(8.dp)
                .background(Color.White),
            label = { Text(stringResource(R.string.username)) }
        )

        Spacer(modifier = Modifier.height(8.dp)) // Adds vertical spacing

        // Email input field
        Text(text = stringResource(R.string.email))
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .padding(8.dp)
                .background(Color.White),
            label = { Text(stringResource(R.string.email)) }
        )

        Spacer(modifier = Modifier.height(8.dp)) // Adds vertical spacing

        // Password input field
        Text(text = stringResource(R.string.password))
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .padding(8.dp)
                .background(Color.White),
            visualTransformation = PasswordVisualTransformation(),
            label = { Text(stringResource(R.string.password)) }
        )

        Spacer(modifier = Modifier.height(16.dp)) // Adds vertical spacing

        // Button for submitting account creation details
        Button( onClick = { navController.navigate("screen1") } ) {
            Text(stringResource(R.string.log_in))
        }

        Spacer(modifier = Modifier.height(16.dp)) // Adds vertical spacing

        // Clickable text for navigating to the login screen
        val loginText = buildAnnotatedString {
            append(stringResource(R.string.already_have_account))

            // Styling for the 'Log in' part of the text
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)) {
                append(stringResource(R.string.log_in_clickable))
            }
        }
        ClickableText(
            text = loginText,
            onClick = { navController.navigate("screen1") }
        )
    }
}


