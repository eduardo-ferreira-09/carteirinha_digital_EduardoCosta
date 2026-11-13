package com.rafaelcosta.carteirinhadigital2devest_b.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rafaelcosta.carteirinhadigital2devest_b.app.di.AppContainer
import com.rafaelcosta.carteirinhadigital2devest_b.app.navigation.ProfileGuard
import com.rafaelcosta.carteirinhadigital2devest_b.feature.login.domain.model.PerfilAcesso

import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.home.presentation.screen.HomeProfessorScreen
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.UnidadeCurricularViewModel
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.factory.UnidadeCurricularViewModelFactory
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.screen.UnidadeCurricularScreen


@Composable
fun App(
    container: AppContainer
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {


        composable(route = "login") {
            // TODO: CHAMA AQUI A TUA TELA DE LOGIN ORIGINAL!


        }




        composable(route = "home_professor") {
            ProfileGuard(
                perfilEsperado = PerfilAcesso.PROFESSOR,
                usuarioFlow = container.sessionTokenStore.usuarioFlow,
                onSessaoAusente = { navController.navigate("login") },
                onPerfilInvalido = { navController.navigate("login") }
            ) { usuarioReal ->
                HomeProfessorScreen(
                    usuarioLogado = usuarioReal,
                    onTurmasClick = { navController.navigate("turmas_professor") },
                    onUnidadesCurricularesClick = { navController.navigate("unidades_curriculares_professor") }
                )
            }
        }


        composable(route = "unidades_curriculares_professor") {
            val viewModel: UnidadeCurricularViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
                factory = UnidadeCurricularViewModelFactory(
                    repository = container.unidadeCurricularRepositoryProfessor
                )
            )
            UnidadeCurricularScreen(viewModel = viewModel)
        }


        composable(route = "turmas_professor") { }

    }
}