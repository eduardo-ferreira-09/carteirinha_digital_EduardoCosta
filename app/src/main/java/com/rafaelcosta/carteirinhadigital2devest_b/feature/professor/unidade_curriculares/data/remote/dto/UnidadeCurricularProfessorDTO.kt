package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.data.remote.dto

import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.model.UnidadeCurricular
import kotlinx.serialization.Serializable

@Serializable
data class UnidadeCurricularProfessorDTO(
    val id: Int,
    val nome: String,
    val turmaId: Int,
    val turma: String,
    val cargaHoraria: Int,
    val quantidadeAulas: Int,
    val aulasRealizadas: Int,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
) {
    fun toDomain(): UnidadeCurricular {
        return UnidadeCurricular(
            id = id,
            nome = nome,
            turmaId = turmaId,
            turma = turma,
            cargaHoraria = cargaHoraria,
            quantidadeAulas = quantidadeAulas,
            aulasRealizadas = aulasRealizadas,
            diasSemana = diasSemana,
            horarioInicio = horarioInicio,
            horarioFim = horarioFim
        )
    }
}