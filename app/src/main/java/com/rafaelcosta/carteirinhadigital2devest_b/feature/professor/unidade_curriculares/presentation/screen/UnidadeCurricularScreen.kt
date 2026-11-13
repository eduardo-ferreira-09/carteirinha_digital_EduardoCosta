package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.UnidadeCurricularViewModel
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.component.UnidadeCurricularCard

@Composable
fun UnidadeCurricularScreen(
    modifier: Modifier = Modifier,
    viewModel: UnidadeCurricularViewModel
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.carregar()
    }

    when {
        uiState.isLoading -> {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        uiState.errorMessage != null -> {
            Column(
                modifier = modifier.fillMaxSize().padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = uiState.errorMessage!!, color = MaterialTheme.colorScheme.error)
                Button(onClick = { viewModel.carregar() }, modifier = Modifier.padding(top = 16.dp)) {
                    Text("Tentar novamente")
                }
            }
        }
        uiState.unidades.isEmpty() -> {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Nenhuma unidade curricular encontrada.")
            }
        }
        else -> {
            LazyColumn(
                modifier = modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(items = uiState.unidades, key = { it.id }) { unidade ->
                    UnidadeCurricularCard(unidadeCurricular = unidade)
                }
            }
        }
    }
}