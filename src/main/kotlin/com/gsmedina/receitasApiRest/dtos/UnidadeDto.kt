package com.gsmedina.receitasApiRest.dtos

import javax.validation.constraints.NotEmpty

class UnidadeDto (
    @get:NotEmpty(message = "Unidade nao pode ser vazio")
    val nomeUnidade: String,

    val id: Long
)