package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation

import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val isLoading: Boolean = false,
    val unidades: List<UnidadeCurricular> = emptyList(),
    val errorMessage: String? = null
)