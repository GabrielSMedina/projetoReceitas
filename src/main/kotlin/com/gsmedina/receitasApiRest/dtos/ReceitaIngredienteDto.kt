package com.gsmedina.receitasApiRest.dtos

import com.gsmedina.receitasApiRest.models.Ingrediente
import com.gsmedina.receitasApiRest.models.Receita
import com.gsmedina.receitasApiRest.models.Unidade
import javax.persistence.Column
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.validation.constraints.NotEmpty

class ReceitaIngredienteDto (

    val quantidadeIngrediente: Int,
    @OneToMany
    @JoinColumn(name = "receitas")
    @Column(name = "id_receita")
    val idReceita: Long,

    @OneToMany
    @JoinColumn(name = "ingredientes")
    @Column(name = "id_ingrediente")
    val idIngrediente: Long,

    @OneToMany
    @JoinColumn(name = "unidades")
    @Column(name = "id_unidade")
    val idUnidade: Long,

    val id: Long
)