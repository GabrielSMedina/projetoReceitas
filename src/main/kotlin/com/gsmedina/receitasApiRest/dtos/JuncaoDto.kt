package com.gsmedina.receitasApiRest.dtos

import com.gsmedina.receitasApiRest.models.Ingrediente
import com.gsmedina.receitasApiRest.models.Receita
import com.gsmedina.receitasApiRest.models.Unidade
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty

class JuncaoDto (
    //Variaveis Receita
    @get:NotEmpty(message = "Nome nao pode ser vazio")
    @get:Length(min = 3, max = 255, message = "Nome deve conter no maximo 255 caracteres e no minimo 3")
    val nomeReceita: String,

    @get:NotEmpty(message = "Nome nao pode ser vazio")
    val minutosPreparo: String,

    @get:NotEmpty(message = "Nome nao pode ser vazio")
    val porcoes: String,

    @get:NotEmpty(message = "Nome nao pode ser vazio")
    val modoPreparo: String,

    val idReceita: Long,

    //Variaveis Ingrediente
    @get:NotEmpty(message = "Nome nao pode ser vazio")
    val nomeIngrediente: String,
    val idIngrediente: Long,

    //variaveis unidade
    @get:NotEmpty(message = "Nome nao pode ser vazio")
    val nomeUnidade: String,
    val idUnidade: Long,

    //Variaveis ReceitaIngrediente
    val quantidadeIngrediente: Int,
    val receita: Receita,
    val ingrediente: Ingrediente,
    val unidade: Unidade,
    val idRecietaIngrediente: Long
        )