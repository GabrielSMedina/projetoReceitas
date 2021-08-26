package com.gsmedina.receitasApiRest.models

import javax.persistence.*

@Entity
@Table(name = "receitas_ingredientes")
class ReceitaIngrediente (
    val quantidade_ingrediente: Int,

    //Chave estrangeira no objeto
    @ManyToOne
    val receita: Receita,
    @ManyToOne
    val ingrediente: Ingrediente,
    @ManyToOne
    val unidade: Unidade,

    //Geracao automatica do Id e definicao da Primary Key
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id_recieta_ingrediente: Long
        )