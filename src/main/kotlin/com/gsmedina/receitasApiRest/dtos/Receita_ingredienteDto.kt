package com.gsmedina.receitasApiRest.dtos

import com.gsmedina.receitasApiRest.models.Ingrediente
import com.gsmedina.receitasApiRest.models.Receita
import com.gsmedina.receitasApiRest.models.Unidade
import javax.validation.constraints.NotEmpty

class Receita_ingredienteDto (
    @get:NotEmpty(message = "quantidade de ingredientes nao pode ser vazio")
    val quantidadeIngrediente: Int,
    val idReceita: Receita,
    val idIngrediente: Ingrediente,
    val idUnidade: Unidade,

    val id: Long
)