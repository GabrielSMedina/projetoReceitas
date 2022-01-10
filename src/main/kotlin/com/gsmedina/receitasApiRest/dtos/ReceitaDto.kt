package com.gsmedina.receitasApiRest.dtos

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class ReceitaDto (
    @get:NotEmpty(message = "Nome nao pode ser vazio")
    @get:Length(min = 3, max = 255, message = "Nome deve conter no maximo 255 caracteres e no minimo 3")
    val nomeReceita: String,

    @get:NotNull
    val minutosPreparo: Int,

    @get:NotNull
    val porcoes: Int,

    @get:NotEmpty(message = "Modo de preparo nao pode ser vazio")
    val modoPreparo: String,

    val receitaIngredientes: List<ReceitaIngredienteDto>
        )