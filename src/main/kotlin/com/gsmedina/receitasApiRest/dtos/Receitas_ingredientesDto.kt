package com.gsmedina.receitasApiRest.dtos

import com.gsmedina.receitasApiRest.models.Ingrediente
import com.gsmedina.receitasApiRest.models.Receitas
import com.gsmedina.receitasApiRest.models.Unidade
import javax.validation.constraints.NotEmpty

class Receitas_ingredientesDto (
    @get:NotEmpty(message = "quantidade de ingredientes nao pode ser vazio")
    val quantidade_ingrediente: Int,
    @get:NotEmpty(message = "id da receita nao pode ser vazio")
    val id_receita: Receitas,
    @get:NotEmpty(message = "id do ingrediente nao pode ser vazio")
    val id_ingrediente: Ingrediente,
    @get:NotEmpty(message = "id da unidade nao pode ser vazio")
    val id_unidade: Unidade,

    val id: Long
)