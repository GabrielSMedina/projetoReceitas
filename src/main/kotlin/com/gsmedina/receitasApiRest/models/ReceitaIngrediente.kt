package com.gsmedina.receitasApiRest.models

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "receitas_ingredientes")
class ReceitaIngrediente (
    @Column(name = "quantidade_ingrediente")
    val quantidadeIngrediente: Int,

    @ManyToOne
    @JoinColumn(name = "id_receita")
    val receita: Receita,

    @ManyToOne
    @JoinColumn(name = "id_ingrediente")
    val ingrediente: Ingrediente,

    @ManyToOne
    @JoinColumn(name = "id_unidade")
    val unidade: Unidade,

    @Column(name = "id")
    //Geracao automatica do Id e definicao da Primary Key
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long
        ): Serializable