package com.gsmedina.receitasApiRest.dtos

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty

class ReceitasDto (
    @get:NotEmpty(message = "Nome nao pode ser vazio")
    @get:Length(min = 3, max = 255, message = "Nome deve conter no maximo 255 caracteres e no minimo 3")
    val nome: String,

    @get:NotEmpty(message = "tempo de preparo nao pode ser vazio")
    val minutos_preparo: Int,

    @get:NotEmpty(message = "porcoes nao pode ser vazio")
    val porcoes: Int,
    val id: Long
)