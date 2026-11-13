package com.rafaelcosta.carteirinhadigital2devest_b.core.auth

import com.rafaelcosta.carteirinhadigital2devest_b.feature.login.domain.model.UsuarioLogado
import kotlinx.coroutines.flow.StateFlow

class SessionTokenStore {

    val usuarioFlow: kotlinx.coroutines.flow.StateFlow<UsuarioLogado?> = kotlinx.coroutines.flow.MutableStateFlow(null)

    @Volatile
    private var token: String? = null

    fun salvar(token: String) {
        this.token = token
    }

    fun obter(): String? {
        return token
    }

    fun limpar() {
        token = null
    }
}