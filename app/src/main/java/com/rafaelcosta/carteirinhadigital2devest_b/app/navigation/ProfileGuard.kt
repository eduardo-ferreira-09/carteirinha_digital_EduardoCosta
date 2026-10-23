package com.rafaelcosta.carteirinhadigital2devest_b.app.navigation

@Composable
internal fun ProfileGuard(
    usuarioFlow: StateFlow<UsuarioLogado?>,
    perfilEsperado: PerfilAcesso,
    onSessaoAusente: () -> Unit,
    onPerfilInvalido: (PerfilAcesso) -> Unit,
    content: @Composable (UsuarioLogado) -> Unit
) {
    val usuario by usuarioFlow.collectAsStateWithLifecycle()
    val usuarioAtual = usuario

    if (usuarioAtual == null) {
        LaunchedEffect(Unit) {
            onSessaoAusente()
        }
        return
    }

    if (usuarioAtual.perfil != perfilEsperado) {
        LaunchedEffect(usuarioAtual.perfil) {
            onPerfilInvalido(usuarioAtual.perfil)
        }
        return
    }
    content(usuarioAtual)
}