package com.jlahougue.runique

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jlahougue.auth.presentation.intro.IntroScreenRoot
import com.jlahougue.auth.presentation.login.LoginScreenRoot
import com.jlahougue.auth.presentation.register.RegisterScreenRoot
import kotlinx.serialization.Serializable

@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AuthGraph
    ) {
        authGraph(navController)
        runGraph(navController)
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
                    navController.navigate(AuthGraph.Login) {
                        popUpTo<AuthGraph.Register> {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                }
            )
        }

        composable<AuthGraph.Login> {
            LoginScreenRoot(
                onLoginSuccess = {
                    navController.navigate(RunGraph) {
                        popUpTo<AuthGraph> {
                            inclusive = true
                        }
                    }
                },
                onSignUpClick = {
                    navController.navigate(AuthGraph.Register) {
                        popUpTo<AuthGraph.Login> {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Serializable
object RunGraph {
    @Serializable
    object Overview
}

private fun NavGraphBuilder.runGraph(navController: NavHostController) {
    navigation<RunGraph>(startDestination = RunGraph.Overview) {
        composable<RunGraph.Overview> {
            Text("Home")
        }
    }
}
