package com.gsmedina.receitasApiRest.models

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class Unidades (
    val unidade: String,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long
        )