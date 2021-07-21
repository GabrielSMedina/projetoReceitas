package com.gsmedina.receitasApiRest.repositories

import com.gsmedina.receitasApiRest.models.Receita
import org.springframework.data.jpa.repository.JpaRepository

//Permite o acesso as funcoes da JPA e a definicao de funcoes proprias
interface ReceitaRepository: JpaRepository<Receita, Long> {

    fun findByNome(nome: String): Receita?

}