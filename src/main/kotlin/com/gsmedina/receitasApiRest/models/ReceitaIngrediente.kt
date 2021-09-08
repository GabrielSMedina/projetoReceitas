package com.gsmedina.receitasApiRest.models

import javax.persistence.*

@Entity
@Table(name = "receitas_ingredientes")
class ReceitaIngrediente (
    @Column(name = "quantidade_ingrediente")
    val quantidadeIngrediente: Int,

    @Column(name = "id_receita")
    val idReceita: Long,

    @Column(name = "id_ingrediente")
    val idIngrediente: Long,

    @Column(name = "id_unidade")
    val idUnidade: Long,

    @Column(name = "id_receita_ingrediente")
    //Geracao automatica do Id e definicao da Primary Key
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idRecietaIngrediente: Long
        )