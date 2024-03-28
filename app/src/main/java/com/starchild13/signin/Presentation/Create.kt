package com.starchild13.signin.Presentation

// Import statements (you would need to adjust these based on your actual package structure and needs)
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.starchild13.signin.R
import com.starchild13.signin.ui.theme.DarkerPink


// Create Account Screen

@Composable
fun CreateScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var acceptedTerms by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

    )
         {

        Text(
            text = stringResource(R.string.create_account),
            fontSize = 36.sp, // Set the font size to 24 sp (scale-independent pixels)
            fontWeight = FontWeight.ExtraBold,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = stringResource(R.string.username), fontSize = 15.sp)
        // Username TextField
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(stringResource(R.string.username)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))

        Text(text = stringResource(R.string.email), fontSize = 15.sp)
        // Email TextField
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(stringResource(R.string.email)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))

        Text(text = stringResource(R.string.password), fontSize = 15.sp)
        // Password TextField

             var passwordVisible by remember { mutableStateOf(false) }

             OutlinedTextField(
                 value = password, // The current value of the password field
                 onValueChange = { password = it }, // Update the password value when it changes
                 label = { Text(stringResource(R.string.password)) }, // The label text for the TextField
                 modifier = Modifier.fillMaxWidth(), // Make the TextField fill the maximum width
                 singleLine = true, // Make the TextField a single line
                 visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(), // Toggle password visibility
                 keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }), // Hide the keyboard when the Done action is triggered
                 shape = RoundedCornerShape(8.dp), // Set the shape of the TextField
                 trailingIcon = {
                     // Determine the icon based on the passwordVisible state
                     val image = if (passwordVisible) painterResource(id = R.drawable.visibility_icon) else painterResource(id = R.drawable.off_visibility_icon)

                     IconButton(onClick = { passwordVisible = !passwordVisible }) {
                         // Apply Modifier.size to adjust the icon size
                         Icon(
                             painter = image,
                             contentDescription = "Toggle password visibility",
                             modifier = Modifier.size(16.dp) // Adjust size as needed
                         )
                     }
                 }

             )



             Spacer(modifier = Modifier.height(16.dp))

        // Terms and Conditions Checkbox
        Row(verticalAlignment = Alignment.CenterVertically) {
            val checkboxIcon = if (acceptedTerms) R.drawable.circle_with_check_symbol else R.drawable.radio

            Icon(
                painter = painterResource(id = checkboxIcon),
                contentDescription = "Checkbox",
                modifier = Modifier
                    .clickable { acceptedTerms = !acceptedTerms }
                    .size(24.dp), // Adjust size as needed
                tint = Color.Unspecified // Apply no tint to display the original drawable colors
            )
            Text(text = stringResource(R.string.accept_terms), fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.height(32.dp))

        // Sign Up Button
        Button(
            onClick = { /* TODO: Implement sign-up logic */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DarkerPink ,  // Background color of the button
            contentColor = Color.White  // Color of the text and icons within the button

        )
        ) {
            Text(text = stringResource(R.string.sign_up))
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Navigate to Sign In Text
             Column(
                 horizontalAlignment = Alignment.CenterHorizontally,
                 verticalArrangement = Arrangement.Center,
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(16.dp),

             ) {
                 Row(verticalAlignment = Alignment.CenterVertically,
                     horizontalArrangement = Arrangement.Center){

                     Text(
                         text = stringResource(R.string.already_have_account),
                         fontSize = 12.sp,
                         modifier = Modifier

                     )

                     Spacer(modifier = Modifier.width(8.dp)) // Adjust as needed for spacing

                     Text(
                         text = stringResource(R.string.log_in),
                         modifier = Modifier
                             .clickable { navController.navigate("screen1") },
                         fontWeight = FontWeight.Bold,
                         textDecoration = TextDecoration.Underline,
                         color = DarkerPink,
                         fontSize = 12.sp
                         )
                 }

             }

         }
}







