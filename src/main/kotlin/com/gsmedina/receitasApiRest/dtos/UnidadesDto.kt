package com.gsmedina.receitasApiRest.dtos

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty

class UnidadesDto (
    @get:NotEmpty(message = "Unidade nao pode ser vazio")
    val unidade: String,

    val id: Long
)