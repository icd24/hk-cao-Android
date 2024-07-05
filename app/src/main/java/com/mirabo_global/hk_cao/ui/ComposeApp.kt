package com.mirabo_global.hk_cao.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mirabo_global.hk_cao.ui.splash.SplashScreen
import com.mirabo_global.hk_cao.ui.walk_through.WalkThroughScreen

@Composable
fun ComposeApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.SPLASH
    ) {
        composable(Route.SPLASH) {
            SplashScreen(
                onNextScreen = {
                    navController.navigate(Route.WALKTHROUGH)
                }
            )
        }

        composable(Route.WALKTHROUGH) {
            WalkThroughScreen {
            }
        }
    }
}

object Route {
    const val SPLASH = "splash"
    const val WALKTHROUGH = "wall_through"
}

object Argument {
    const val USERNAME = "username"
}