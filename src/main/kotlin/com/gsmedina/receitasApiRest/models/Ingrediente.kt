package com.gsmedina.receitasApiRest.models

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "ingredientes")
class Ingrediente (
    @Column(name = "nome_ingrediente")
    val nomeIngrediente: String,

    @Column(name = "id")
    //Geracao automatica do Id e definicao da Primary Key
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long
        ): Serializable