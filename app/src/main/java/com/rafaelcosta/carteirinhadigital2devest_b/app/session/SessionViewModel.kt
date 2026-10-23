package com.rafaelcosta.carteirinhadigital2devest.app.session

class SessionViewModel(
    private val sessionTokenStore:SessionTokenStore
) : ViewModel() {
    private val _usuarioLogado =MutableStateFlow<UsuarioLogado?>(null)
    val usuarioLogado : StateFlow<UsuarioLogado?> = _usuarioLogado.asStateFlow()
    fun setUsuarioLogado(usuario: UsuarioLogado) {
        sessionTokenStore.salvar(usuario.token)
        _usuarioLogado.value = usuario
    }

    fun limparSessao() {
        sessionTokenStore.limpar()
        _usuarioLogado.value = null
    }
}