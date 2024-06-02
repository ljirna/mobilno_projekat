package com.example.myapplication.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.model.SalonObject
import com.example.myapplication.model.Salons
import com.example.myapplication.screens.BeautySalon
import com.example.myapplication.screens.BeautySalonDestination
//import com.example.myapplication.screens.BeautySalon
//import com.example.myapplication.screens.BeautySalonDestination
import com.example.myapplication.screens.Home
import com.example.myapplication.screens.HomeDestination
import com.example.myapplication.screens.LoginDestination
import com.example.myapplication.screens.HomeDestination.userId
import com.example.myapplication.screens.LoginScreen
import com.example.myapplication.screens.ProfileDestination
import com.example.myapplication.screens.ProfileScreen
import com.example.myapplication.screens.Search
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
        composable(
            route = LoginDestination.route
        ) {
            LoginScreen(
                navigateToSignup = { navController.navigate("${SignupDestination.route}") },
                navigateToHomePage = { navController.navigate("${HomeDestination.route}/${it}")}
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
        composable(
            route = HomeDestination.routeWithArgs,
            arguments = listOf(navArgument(HomeDestination.userId){
                type = NavType.IntType
            })
        ) {
            val userId = it.arguments?.getInt(HomeDestination.userId) ?: 0
            Home(
                navigateToProfile = { navController.navigate("${ProfileDestination.routeWithArgs}")},
                navigateToBeautySalon = { navController.navigate("${BeautySalonDestination.route}/$userId/$it") }
            )
        }
        composable(
            route = ProfileDestination.route,
            arguments = listOf(navArgument(ProfileDestination.userId){
                type = NavType.IntType
            })
            ) {
            ProfileScreen(
                navigateToHomePage = { navController.navigate("${HomeDestination.routeWithArgs}") },
                userId = it.arguments?.getInt(ProfileDestination.userId) ?: 0,
                navigateToLogin = { navController.navigate("${LoginDestination.route}") }
            )
        }
        composable(
            route = BeautySalonDestination.routeWithArgs,
            arguments = listOf(navArgument(BeautySalonDestination.userId){
                type = NavType.IntType
            },
                navArgument(BeautySalonDestination.salonId){
                    type = NavType.IntType
                }
                )
        ) {
            BeautySalon(
                navigateToHomePage = {navController.navigate("${HomeDestination.routeWithArgs}")},
                userId = it.arguments?.getInt(BeautySalonDestination.userId) ?: 0,
                salonId = it.arguments?.getInt(BeautySalonDestination.salonId) ?: 0
            )
        }
    }
}