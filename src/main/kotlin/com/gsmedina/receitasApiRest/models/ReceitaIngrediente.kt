package com.gsmedina.receitasApiRest.models

import javax.persistence.*

@Entity
@Table(name = "receitas_ingredientes")
class ReceitaIngrediente (
    @Column(name = "quantidade_ingrediente")
    val quantidadeIngrediente: Int,

    @OneToMany
    @Column(name = "id_receita")
    val receita: Receita,

    @Column(name = "id_ingrediente")
    val ingrediente: Ingrediente,

    @Column(name = "id_unidade")
    val unidade: Unidade,

    @Column(name = "id")
    //Geracao automatica do Id e definicao da Primary Key
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long
        )