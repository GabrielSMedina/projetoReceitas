package com.gsmedina.receitasApiRest.models

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class Receitas_ingredientes (
    val quantidade_ingrediente: Int,

    val id_receita: Receitas,

    val id_ingrediente: Ingredientes,

    val id_unidade: Unidades,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long
        )