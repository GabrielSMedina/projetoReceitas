package com.gsmedina.receitasApiRest.security

import com.gsmedina.receitasApiRest.models.Usuario
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UsuarioPrincipal(val usuario:Usuario): UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities: MutableCollection<GrantedAuthority> = mutableListOf<GrantedAuthority>()
        authorities.add(SimpleGrantedAuthority(usuario.perfil.toString()))
        return authorities
    }

    override fun getPassword(): String {
        return usuario.senha
    }

    override fun getUsername(): String {
        return usuario.email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}