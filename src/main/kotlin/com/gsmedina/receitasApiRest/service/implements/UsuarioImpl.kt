package com.gsmedina.receitasApiRest.service.implements

import com.gsmedina.receitasApiRest.models.Usuario
import com.gsmedina.receitasApiRest.repositories.UsuarioRepository

import com.gsmedina.receitasApiRest.service.UsuarioService
import org.springframework.stereotype.Service

//Classe responsavel por implementar os servicos de nossa interface de servicos
@Service
class UsuarioImpl(val usuarioRepository: UsuarioRepository): UsuarioService {
    override fun salvar(usuario: Usuario): Usuario {
        return usuarioRepository.save(usuario)
    }

    override fun buscarNome(nome: String): List<Usuario> {
        return usuarioRepository.findBynomeContaining(nome)
    }

    override fun buscarEmail(email: String): Usuario? {
        return usuarioRepository.findByEmail(email)
    }
}