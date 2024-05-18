package com.jlahougue.runique

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navigation
import com.jlahougue.auth.presentation.intro.IntroScreenRoot
import com.jlahougue.auth.presentation.register.RegisterScreenRoot
import kotlinx.serialization.Serializable

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "auth"
    ) {
        authGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(
        startDestination = "intro",
        route = "auth"
    ) {
        composable(route = "intro") {
            IntroScreenRoot(
                onSignUpClick = {
                    navController.navigate("register")
                },
                onSignInClick = {
                    navController.navigate("login")
                }
            )
        }
        composable(route = "register") {
            RegisterScreenRoot(
                onSignInClick = {
                    navController.navigate("login") {
                        popUpTo("register") {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulRegistration = {
                    navController.navigate("login")
                }
            )
        }
        composable(route = "login") {
            Text("Login")
        }
    }
}
/*
@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AuthGraph
    ) {
        authGraph(navController)
    }
}

@Serializable
object AuthGraph {
    @Serializable
    object Intro

    @Serializable
    object Register

    @Serializable
    object Login
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation<AuthGraph>(startDestination = AuthGraph.Intro) {
        composable<AuthGraph.Intro> {
            IntroScreenRoot(
                onSignUpClick = {
                    navController.navigate(AuthGraph.Register)
                },
                onSignInClick = {
                    navController.navigate(AuthGraph.Login)
                }
            )
        }

        composable<AuthGraph.Register> {
            RegisterScreenRoot(
                onSignInClick = {
                    navController.navigate(AuthGraph.Login) {
                        popUpTo<AuthGraph.Register> {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulRegistration = {
                    navController.navigate(AuthGraph.Login)
                }
            )
        }
    }
}
*/