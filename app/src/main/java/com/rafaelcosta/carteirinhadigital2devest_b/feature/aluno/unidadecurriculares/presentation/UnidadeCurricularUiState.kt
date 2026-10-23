package com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.presentation

import com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val isLoading: Boolean = false,
    val unidades: List<com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.model.UnidadeCurricular> = emptyList(),
    val errorMessage: String? = null
)