package com.gsmedina.receitasApiRest.models

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class Receitas_ingredientes (
    val quantidade_ingrediente: Int,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long
        )