package com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.carteirinha.presentation.component

import kotlin.text.get

@Composable
fun QrCode(
    conteudo: String,
    modifier: Modifier = Modifier
) {
    val bitmap = gerarQrCode(conteudo)

    Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = "QR Code",
        modifier = modifier
    )
}


fun gerarQrCode(
    conteudo: String,
    tamanho: Int = 512,
    margem: Int = 1
): Bitmap {

    val hints = mapOf(
        EncodeHintType.MARGIN to margem
    )

    val writer = QRCodeWriter()
    val bitMatrix = writer.encode(
        conteudo,
        BarcodeFormat.QR_CODE,
        tamanho,
        tamanho,
        hints
    )

    val bitmap = createBitmap(tamanho, tamanho)

    for (x in 0 until tamanho) {
        for (y in 0 until tamanho) {
            bitmap[x, y] = if (bitMatrix[x, y]) Color.BLACK else Color.WHITE
        }
    }

    return bitmap
}