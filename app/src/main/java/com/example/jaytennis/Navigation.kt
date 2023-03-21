package com.example.jaytennis

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation

@Composable
fun Navigation(viewModel: MainViewModel) {
    val navController = rememberNavController()

    fun backUp(): () -> Unit {
        return {
            navController.navigateUp()
        }
    }

    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController, viewModel)
        }
        composable(
            route = Screen.DetailScreen.route + "/{name}/{country}/{age}/{rank}/{height}/{coach}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "1"
                    nullable = false
                }
            )
        ) { entry ->
            DetailScreen(
                onBackClick = backUp(),
                id = entry.arguments?.getString("name") ?:"",
                title = entry.arguments?.getString("country") ?:"",
                author = entry.arguments?.getString("age") ?:"",
                status = entry.arguments?.getString("rank") ?:"",
                fee = entry.arguments?.getString("height") ?:"",
                lastEdited = entry.arguments?.getString("coach") ?:""
            )
        }
    }
}
