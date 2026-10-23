package com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.carteirinha.presentation.component


@Composable
fun LabelText(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        text = text,
        fontSize = 20.sp,
        color = Color.Black,
        textAlign = TextAlign.Right,
        modifier = modifier
    )
}