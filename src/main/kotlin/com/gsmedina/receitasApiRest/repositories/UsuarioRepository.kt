package com.gsmedina.receitasApiRest.repositories

import com.gsmedina.receitasApiRest.models.Usuario
import org.springframework.data.jpa.repository.JpaRepository

//Permite o acesso as funcoes da JPA e a definicao de funcoes proprias
interface UsuarioRepository: JpaRepository <Usuario, String> {

    fun findBynomeContaining(nome: String): List<Usuario>

    fun findByEmail(email: String): Usuario?
}