package com.alpha.mywidgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alpha.mywidgets.screens.CategoryPage
import com.alpha.mywidgets.screens.HomeScreen
import com.alpha.mywidgets.screens.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "onboarding") {
        composable("onboarding") {
            OnboardingScreen().OnboardingPage(navController)
        }
        composable("login") {
            LoginScreen().LoginName(navController)
        }
        composable("home") {
            HomeScreen()
        }
//        composable("home/{email}", arguments = listOf(navArgument("email") {
//            type = NavType.StringType
//        })) {
//            HomeScreen().HomeScreen(navController)
//        }
        composable("category") {
            CategoryPage().FetchCategory()
        }
    }
}


