package com.gsmedina.receitasApiRest.models

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "unidades")
class Unidade (
    @Column(name = "unidade")
    val nomeUnidade: String? = null,

    @Column(name = "id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long
        ): Serializable