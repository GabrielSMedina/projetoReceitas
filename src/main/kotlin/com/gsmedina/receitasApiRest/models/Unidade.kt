package com.gsmedina.receitasApiRest.models

import javax.persistence.*

@Entity
@Table(name = "unidades")
class Unidade (
    val nomeUnidade: String,

    @Column(name = "id_unidade")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idUnidade: Long
        )