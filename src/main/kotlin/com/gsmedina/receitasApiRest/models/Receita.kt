package com.gsmedina.receitasApiRest.models

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "receitas")
class Receita (
    @Column(name = "nome_receita")
    val nomeReceita: String,
    @Column(name = "minutos_preparo")
    val minutosPreparo: String,
    val porcoes: String,
    @Column(name = "modo_preparo")
    val modoPreparo: String,

    @Column(name = "id_receita")
    //Geracao automatica do Id e definicao da Primary Key
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idReceita: Long
)