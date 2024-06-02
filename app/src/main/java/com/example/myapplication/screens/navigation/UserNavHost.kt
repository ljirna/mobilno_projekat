package com.example.myapplication.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.screens.BeautySalonDestination
import com.example.myapplication.screens.Home
import com.example.myapplication.screens.HomeDestination
import com.example.myapplication.screens.LoginDestination
import com.example.myapplication.screens.LoginScreen
import com.example.myapplication.screens.ProfileDestination
import com.example.myapplication.screens.SearchDestination
import com.example.myapplication.screens.SignupDestination
import com.example.myapplication.screens.SignupScreen
import com.example.myapplication.screens.SplashDestination
import com.example.myapplication.screens.SplashScreen

@Composable
fun UserNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = SplashDestination.route) {
        composable(route = LoginDestination.route) {
            LoginScreen(
                navigateToSignup = { navController.navigate("${SignupDestination.route}") },
                navigateToHomePage = { navController.navigate("${HomeDestination.route}") }
            )
        }
        composable(route = SignupDestination.route) {
            SignupScreen(
                navigateToLogin = {navController.navigate("${LoginDestination.route}")}
            )
        }
        composable(route = SplashDestination.route) {
            SplashScreen(
                navigateToLogin = { navController.navigate("${LoginDestination.route}") }
            )
        }
        composable(route = HomeDestination.route) {
            Home(
                navigateToSearch = { navController.navigate("${SearchDestination.route}") },
                navigateToProfile = { navController.navigate("${ProfileDestination.route}") },
                navigateToBeautySalon = { navController.navigate("${BeautySalonDestination.route}") }
            )
        }
    }
}