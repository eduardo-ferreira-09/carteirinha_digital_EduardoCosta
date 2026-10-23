package com.rafaelcosta.carteirinhadigital2devest.app.navigation.auth

import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import com.rafaelcosta.carteirinhadigital2devest_b.app.navigation.auth.AuthRoutes
import com.rafaelcosta.carteirinhadigital2devest_b.app.navigation.professor.GraphRoutes
import com.rafaelcosta.carteirinhadigital2devest_b.feature.login.data.repository.LoginRepository
import com.rafaelcosta.carteirinhadigital2devest_b.feature.login.domain.model.UsuarioLogado
import com.rafaelcosta.carteirinhadigital2devest_b.feature.login.presentation.LoginViewModel
import com.rafaelcosta.carteirinhadigital2devest_b.feature.login.presentation.screen.LoginScreen

fun NavGraphBuilder.authNavGraph(
    loginRepository: LoginRepository,
    onLoginSucesso: (UsuarioLogado) -> Unit
) {
    navigation(
        startDestination = AuthRoutes.LOGIN,
        route = GraphRoutes.AUTH
    ) {
        composable(route = AuthRoutes.LOGIN) {
            val factory = remember(loginRepository) {
                LoginViewModelFactory(
                    repository = loginRepository
                )
            }

            val loginViewModel: LoginViewModel = viewModel(
                factory = factory
            )

            LoginScreen(
                viewModel = loginViewModel,
                onLoginSucesso = onLoginSucesso
            )
        }
    }
}