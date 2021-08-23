package com.gsmedina.receitasApiRest.dtos

import com.gsmedina.receitasApiRest.models.Ingredientes
import com.gsmedina.receitasApiRest.models.Receitas
import com.gsmedina.receitasApiRest.models.Unidades
import javax.validation.constraints.NotEmpty

class Receitas_ingredientesDto (
    @get:NotEmpty(message = "quantidade de ingredientes nao pode ser vazio")
    val quantidade_ingrediente: Int,
    @get:NotEmpty(message = "id da receita nao pode ser vazio")
    val id_receita: Receitas,
    @get:NotEmpty(message = "id do ingrediente nao pode ser vazio")
    val id_ingrediente: Ingredientes,
    @get:NotEmpty(message = "id da unidade nao pode ser vazio")
    val id_unidade: Unidades,

    val id: Long
)