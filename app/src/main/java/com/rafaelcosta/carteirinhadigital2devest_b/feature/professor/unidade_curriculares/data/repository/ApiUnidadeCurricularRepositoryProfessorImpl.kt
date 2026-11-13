package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.data.repository

import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.data.remote.service.UnidadeCurricularProfessorApi
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.model.UnidadeCurricular
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.repository.UnidadeCurricularRepository

class ApiUnidadeCurricularRepositoryProfessorImp(
    private val api: UnidadeCurricularProfessorApi
) : UnidadeCurricularRepository {

    override suspend fun listar(): Result<List<UnidadeCurricular>> {
        return runCatching {
            api.listar().map { it.toDomain() }
        }
    }
}