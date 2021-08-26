package com.gsmedina.receitasApiRest.repositories

import com.gsmedina.receitasApiRest.models.Unidade
import org.springframework.data.jpa.repository.JpaRepository

interface UnidadeRepository: JpaRepository<Unidade, Long> {

    fun findByNomeUnidade(nomeUnidade: String): Unidade?
}