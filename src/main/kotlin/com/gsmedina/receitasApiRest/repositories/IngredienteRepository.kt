package com.gsmedina.receitasApiRest.repositories

import com.gsmedina.receitasApiRest.models.Ingrediente
import org.springframework.data.jpa.repository.JpaRepository

interface IngredienteRepository: JpaRepository<Ingrediente, Long> {

}