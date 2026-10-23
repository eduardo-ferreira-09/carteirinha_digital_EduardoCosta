package com.rafaelcosta.carteirinhadigital2devest.feature.aluno.carteirinha.presentation.component

@Composable
fun InfoAluno(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    fontSizeValue: TextUnit = 35.sp,
    fontWeightValue: FontWeight = FontWeight.Bold
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        LabelText(
            text = label,
            modifier = Modifier.weight(1f)
        )
        ValueText(
            text = value,
            fontSize = fontSizeValue,
            fontWeight = fontWeightValue,
            modifier = Modifier.weight(3f)
        )
    }
}