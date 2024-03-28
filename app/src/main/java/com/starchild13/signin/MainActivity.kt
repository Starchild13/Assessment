package com.starchild13.signin
//Importing libraries and packages needed
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.starchild13.signin.Presentation.CreateScreen
import com.starchild13.signin.Presentation.SignInScreen
import com.starchild13.signin.ui.theme.SignInTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() { //Function that helps me move from one screen to another.
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen1") { //Starts at the SignIn Screen
        composable("screen1") { SignInScreen(navController) }
        composable("screen2") { CreateScreen(navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SignInTheme {
        // Preview the SignInScreen without NavController
        SignInScreen(navController = null) // Pass null or a dummy NavController

    }
}
