package com.gsmedina.receitasApiRest.models

import javax.persistence.*

@Entity
@Table(name = "receitas_ingredientes")
class ReceitaIngrediente (
    @Column(name = "quantidade_ingrediente")
    val quantidadeIngrediente: Int,

    //Chave estrangeira no objeto
    @ManyToOne
    val receita: Receita,
    @ManyToOne
    val ingrediente: Ingrediente,
    @ManyToOne
    val unidade: Unidade,

    @Column(name = "id_recieta_ingrediente")
    //Geracao automatica do Id e definicao da Primary Key
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idRecietaIngrediente: Long
        )