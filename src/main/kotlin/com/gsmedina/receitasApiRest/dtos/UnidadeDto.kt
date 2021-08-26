package com.gsmedina.receitasApiRest.dtos

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty

class UnidadeDto (
    @get:NotEmpty(message = "Unidade nao pode ser vazio")
    val unidade: String,

    val idUnidade: Long
)