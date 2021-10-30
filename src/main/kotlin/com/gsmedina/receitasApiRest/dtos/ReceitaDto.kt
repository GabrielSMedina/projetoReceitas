package com.gsmedina.receitasApiRest.dtos

import com.gsmedina.receitasApiRest.models.ReceitaIngrediente
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty

//Classe para transferir dados entre os sub-sistemas do codigo
class ReceitaDto (
    @get:NotEmpty(message = "Nome nao pode ser vazio")
    @get:Length(min = 3, max = 255, message = "Nome deve conter no maximo 255 caracteres e no minimo 3")
    val nomeReceita: String,

    val minutosPreparo: Int,

    val porcoes: Int,

    @get:NotEmpty(message = "Modo de preparo nao pode ser vazio")
    val modoPreparo: String,

    val receitaIngredientes: List<ReceitaIngredienteDto>
        )