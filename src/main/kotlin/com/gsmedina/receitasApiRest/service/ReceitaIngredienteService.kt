package com.gsmedina.receitasApiRest.service

import com.gsmedina.receitasApiRest.models.ReceitaIngrediente


interface ReceitaIngredienteService {

    fun salvar(receitaIngrediente: ReceitaIngrediente): ReceitaIngrediente

    fun buscarPorId(receitaIngrediente: ReceitaIngrediente): ReceitaIngrediente?
}