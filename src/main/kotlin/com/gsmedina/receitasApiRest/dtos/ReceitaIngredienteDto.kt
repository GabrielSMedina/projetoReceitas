package com.gsmedina.receitasApiRest.dtos

import javax.validation.constraints.NotEmpty

class ReceitaIngredienteDto (

    @get:NotEmpty(message = "quantidade nao pode ser vazio")
    val quantidadeIngrediente: Int,
//    @get:NotEmpty(message = "receita nao pode ser vazio")
//    val receita: Long,
    @get:NotEmpty(message = "ingredinte nao pode ser vazio")
    val ingrediente: IngredienteDto,
    @get:NotEmpty(message = "unidade nao pode ser vazio")
    val unidade: Long,
)