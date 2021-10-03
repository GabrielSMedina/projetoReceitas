package com.gsmedina.receitasApiRest.dtos

class ReceitaIngredienteDto (

    val quantidadeIngrediente: Int,

    val receita: ReceitaDto,

    val ingrediente: IngredienteDto,

    val unidade: UnidadeDto,

    val id: Long
)