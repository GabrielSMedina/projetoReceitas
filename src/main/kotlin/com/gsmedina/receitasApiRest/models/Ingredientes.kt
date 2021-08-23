package com.gsmedina.receitasApiRest.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Ingredientes (
    val nome_ingrediente: String,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long
        )