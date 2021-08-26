package com.gsmedina.receitasApiRest.repositories

import com.gsmedina.receitasApiRest.models.ReceitaIngrediente
import org.springframework.data.jpa.repository.JpaRepository

interface ReceitaIngredienteRepository: JpaRepository<ReceitaIngrediente, Long> {
}