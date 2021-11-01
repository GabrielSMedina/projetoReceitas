package com.gsmedina.receitasApiRest.repositories

import com.gsmedina.receitasApiRest.models.Receita
import org.springframework.data.jpa.repository.JpaRepository

interface ReceitaRepository: JpaRepository<Receita, Long> {

    fun findByNomeReceita(nome: String): Receita?

}