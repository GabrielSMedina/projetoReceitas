package com.gsmedina.receitasApiRest.models

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class Receitas (
    val nome_receita: String,
    val minutos_preparo: Int,
    val porcoes: Int,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long
        )