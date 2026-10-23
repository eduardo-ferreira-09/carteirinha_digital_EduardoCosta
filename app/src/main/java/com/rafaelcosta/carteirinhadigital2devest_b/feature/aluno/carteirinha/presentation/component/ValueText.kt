package com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.carteirinha.presentation.component

@Composable
fun ValueText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 35.sp,
    fontWeight: FontWeight = FontWeight.Bold
) {
    Text(
        text = text,
        fontSize = fontSize,
        color = Color.Black,
        fontWeight = fontWeight,
        modifier = modifier
    )
}