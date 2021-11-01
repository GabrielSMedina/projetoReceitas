package com.gsmedina.receitasApiRest.models

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "ingredientes")
class Ingrediente (
    @Column(name = "nome_ingrediente")
    val nomeIngrediente: String,

    @Column(name = "id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
        ): Serializable