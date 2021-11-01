package com.gsmedina.receitasApiRest.models

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "receitas_ingredientes")
class ReceitaIngrediente(
    @Column(name = "quantidade_ingrediente")
    var quantidadeIngrediente: Int,

    @OneToOne
    @JoinColumn(name = "id_ingrediente")
    var ingrediente: Ingrediente?,

    @ManyToOne
    @JoinColumn(name = "id_unidade")
    var unidade: Unidade?,

    @ManyToOne
    @JoinColumn(name = "id_receita")
    var receita: Receita? = null,

    @Column(name = "id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        ): Serializable