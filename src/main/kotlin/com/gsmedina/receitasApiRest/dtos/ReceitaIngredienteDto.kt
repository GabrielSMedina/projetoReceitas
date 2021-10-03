package com.gsmedina.receitasApiRest.dtos

import com.gsmedina.receitasApiRest.models.Ingrediente
import com.gsmedina.receitasApiRest.models.Receita
import com.gsmedina.receitasApiRest.models.Unidade

class ReceitaIngredienteDto (

    val quantidadeIngrediente: Int,

    val receita: ReceitaDto,

    val ingrediente: IngredienteDto,

    val unidade: UnidadeDto,

    val id: Long
)