package com.gsmedina.receitasApiRest.models

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "receitas")
class Receita (
    @Column(name = "nome_receita")
    val nomeReceita: String,
    @Column(name = "minutos_preparo")
    val minutosPreparo: Int,
    val porcoes: Int,
    @Column(name = "modo_preparo")
    val modoPreparo: String,

    @ManyToOne
    val receitaIngredientes: List<ReceitaIngrediente>,

    @Column(name = "id")
    //Geracao automatica do Id e definicao da Primary Key
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long
)