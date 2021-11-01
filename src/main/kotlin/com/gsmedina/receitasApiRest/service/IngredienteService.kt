package com.gsmedina.receitasApiRest.service

import com.gsmedina.receitasApiRest.dtos.IngredienteDto
import com.gsmedina.receitasApiRest.models.Ingrediente

interface IngredienteService {

    fun buscarPorNome(nomeIngrediente: String): Ingrediente?

    fun salvar(omeIngrediente: String): Ingrediente

    fun listarTodosIngredientes(): List<Ingrediente>

    fun deletar(id: Long)

    fun buscarPorId(id: Long): Ingrediente?

    fun atualizar(ingredienteDto: IngredienteDto, id: Long): Ingrediente
}