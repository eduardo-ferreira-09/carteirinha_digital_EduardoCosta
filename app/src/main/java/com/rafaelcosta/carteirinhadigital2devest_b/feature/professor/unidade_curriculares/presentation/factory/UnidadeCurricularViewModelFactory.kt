package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.repository.UnidadeCurricularRepository
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.UnidadeCurricularViewModel

class UnidadeCurricularViewModelFactory(
    private val repository: UnidadeCurricularRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UnidadeCurricularViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UnidadeCurricularViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido")
    }
}