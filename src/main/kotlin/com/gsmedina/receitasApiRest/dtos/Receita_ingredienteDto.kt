package com.gsmedina.receitasApiRest.dtos

import com.gsmedina.receitasApiRest.models.Ingrediente
import com.gsmedina.receitasApiRest.models.Receita
import com.gsmedina.receitasApiRest.models.Unidade
import javax.validation.constraints.NotEmpty

class Receita_ingredienteDto (
    @get:NotEmpty(message = "quantidade de ingredientes nao pode ser vazio")
    val quantidadeIngrediente: Int,
    @get:NotEmpty(message = "id da receita nao pode ser vazio")
    val idReceita: Receita,
    @get:NotEmpty(message = "id do ingrediente nao pode ser vazio")
    val idIngrediente: Ingrediente,
    @get:NotEmpty(message = "id da unidade nao pode ser vazio")
    val idUnidade: Unidade,

    val id: Long
)