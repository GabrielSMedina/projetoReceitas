package com.gsmedina.receitasApiRest.models

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "receitas")
class Receita (
    val nome_receita: String,
    val minutos_preparo: String,
    val porcoes: String,
    val modo_preparo: String,

    //Geracao automatica do Id e definicao da Primary Key
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id_receita: Long
)