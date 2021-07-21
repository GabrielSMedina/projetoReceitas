package com.gsmedina.receitasApiRest.dtos

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty

//Classe para transferir dados entre os sub-sistemas do codigo
class ReceitaDto (
    @get:NotEmpty(message = "Nome nao pode ser vazio")
    @get:Length(min = 3, max = 255, message = "Nome deve conter no maximo 255 caracteres e no minimo 3")
    val nome: String,

    @get:NotEmpty(message = "Ingredientes nao pode ser vazio")
    val ingredientes: String,

    @get:NotEmpty(message = "Modo de preparo nao pode ser vazio")
    val modo_preparo: String,
    val id: Long
        )