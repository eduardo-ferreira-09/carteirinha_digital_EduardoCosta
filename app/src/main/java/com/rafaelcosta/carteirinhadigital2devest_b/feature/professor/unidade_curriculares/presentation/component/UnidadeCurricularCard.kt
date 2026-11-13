package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.model.UnidadeCurricular

@Composable
fun UnidadeCurricularCard(
    modifier: Modifier = Modifier,
    unidadeCurricular: UnidadeCurricular
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = unidadeCurricular.nome, style = MaterialTheme.typography.titleLarge)
            Text(text = "Turma: ${unidadeCurricular.turma}", color = MaterialTheme.colorScheme.primary)

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Aulas: ${unidadeCurricular.aulasRealizadas}/${unidadeCurricular.quantidadeAulas}")
                Text(text = "Carga: ${unidadeCurricular.cargaHoraria}h")
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = unidadeCurricular.diasSemana.joinToString(", "))
                Text(text = "${unidadeCurricular.horarioInicio} - ${unidadeCurricular.horarioFim}")
            }
        }
    }
}