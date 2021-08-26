package com.gsmedina.receitasApiRest.models

import javax.persistence.*

@Entity
@Table(name = "receitas_ingredientes")
class Receita_ingrediente (
    val quantidade_ingrediente: Int,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long
        )