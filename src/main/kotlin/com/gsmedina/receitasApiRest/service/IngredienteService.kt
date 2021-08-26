package com.gsmedina.receitasApiRest.service

import com.gsmedina.receitasApiRest.models.Ingrediente

interface IngredienteService {

    fun buscarPorNome(nomeIngrediente: String): Ingrediente?

    fun salvar(ingrediente: Ingrediente): Ingrediente

    fun listarTodosIngredientes(): List<Ingrediente>?

    fun deletar(id: Long)

    fun buscarPorId(id: Long): Ingrediente?
}