package com.gsmedina.receitasApiRest.dtos

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty

class Receitas_ingredientesDto (
    @get:NotEmpty(message = "Ingredientes nao pode ser vazio")
    val quantidade_ingrediente: Int,

    val id: Long
)