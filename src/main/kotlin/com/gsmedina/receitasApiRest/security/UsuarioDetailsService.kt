package com.gsmedina.receitasApiRest.security

import com.gsmedina.receitasApiRest.models.Usuario
import com.gsmedina.receitasApiRest.service.UsuarioService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UsuarioDetailsService(val usuarioService: UsuarioService): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        if (username != null) {
            val usuario: Usuario? = usuarioService.buscarEmail(username)
            if (usuario != null) {
                return UsuarioPrincipal(usuario)
            }
        }
        throw UsernameNotFoundException(username)
    }
}