package com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.carteirinha.presentation.component

@Composable
fun PerfilAluno(
    nome: String,
    matricula: String,
    curso: String,
    idFoto: Int =
        R.drawable.login
) {

    Column(
        verticalArrangement =
            Arrangement.spacedBy(
                10.dp
            ),
        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Image(
            painter =
                painterResource(
                    id = idFoto
                ),
            contentDescription =
                "Foto do aluno",
            contentScale =
                ContentScale.Crop,
            modifier =
                Modifier
                    .size(180.dp)
                    .clip(
                        CircleShape
                    )
                    .border(
                        width = 2.dp,
                        color =
                            MaterialTheme
                                .colorScheme
                                .primary,
                        shape =
                            CircleShape
                    )
        )

        InfoAluno(
            label = "Nome",
            value = nome
        )

        InfoAluno(
            label = "Matrícula",
            value = matricula,
            fontSizeValue = 22.sp,
            fontWeightValue =
                FontWeight.SemiBold
        )

        InfoAluno(
            label = "Curso",
            value = curso,
            fontSizeValue = 22.sp,
            fontWeightValue =
                FontWeight.Normal
        )
    }
}