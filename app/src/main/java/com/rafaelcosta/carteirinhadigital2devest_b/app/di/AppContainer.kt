package com.rafaelcosta.carteirinhadigital2devest_b.app.di

import com.rafaelcosta.carteirinhadigital2devest_b.core.auth.SessionTokenStore
import com.rafaelcosta.carteirinhadigital2devest_b.feature.login.data.repository.LoginRepository

interface AppContainer {
    val sessionTokenStore: SessionTokenStore
    val loginRepository: LoginRepository
    val unidadeCurricularRepository: com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.repository.UnidadeCurricularRepository

    val unidadeCurricularRepositoryProfessor: com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.repository.UnidadeCurricularRepository
}