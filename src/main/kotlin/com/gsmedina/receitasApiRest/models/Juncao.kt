package com.gsmedina.receitasApiRest.models

import javax.persistence.*

class Juncao (
    //Variaveis Receita
    val nomeReceita: String,
    val minutosPreparo: String,
    val porcoes: String,
    val modoPreparo: String,
    val idReceita: Long,

    //Variaveis Ingrediente
    val nomeIngrediente: String,
    val idIngrediente: Long,

    //variaveis unidade
    val nomeUnidade: String,
    val idUnidade: Long,

    //Variaveis ReceitaIngrediente
    val quantidadeIngrediente: Int,
    val receita: Receita,
    val ingrediente: Ingrediente,
    val unidade: Unidade,
    val idRecietaIngrediente: Long
        )