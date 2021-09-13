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

    val idReceita: Long,

    val idIngrediente: Long,

    val idUnidade: Long,

    val id: Long
)