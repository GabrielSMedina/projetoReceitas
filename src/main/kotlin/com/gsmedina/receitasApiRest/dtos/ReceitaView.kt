package com.gsmedina.receitasApiRest.dtos

import com.gsmedina.receitasApiRest.models.Ingrediente
import com.gsmedina.receitasApiRest.models.Unidade

class ReceitaView (

    val nomeReceita: String,

    val minutosPreparo: Int,

    val porcoes: Int,

    val modoPreparo: String,

    val ingrediente: List<Ingrediente>,

    val unidade: List<Unidade>
        )