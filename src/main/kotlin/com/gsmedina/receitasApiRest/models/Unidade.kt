package com.gsmedina.receitasApiRest.models

import javax.persistence.*

@Entity
@Table(name = "unidades")
class Unidade (
    val unidade: String,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id_unidade: Long
        )