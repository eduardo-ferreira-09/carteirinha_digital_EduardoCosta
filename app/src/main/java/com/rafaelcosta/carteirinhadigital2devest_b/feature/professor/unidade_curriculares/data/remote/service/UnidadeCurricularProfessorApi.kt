package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.data.remote.service

import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.data.remote.dto.UnidadeCurricularProfessorDTO
import retrofit2.http.GET

interface UnidadeCurricularProfessorApi {
    @GET("professores/me/unidades-curriculares")
    suspend fun listar(): List<UnidadeCurricularProfessorDTO>
}