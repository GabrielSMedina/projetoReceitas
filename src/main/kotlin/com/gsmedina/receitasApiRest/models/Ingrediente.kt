package com.gsmedina.receitasApiRest.models

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "ingredientes")
class Ingrediente (
    val nome_ingrediente: String,

    //Geracao automatica do Id e definicao da Primary Key
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id_ingrediente: Long
        )