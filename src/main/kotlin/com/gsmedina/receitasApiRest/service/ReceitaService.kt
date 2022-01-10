package com.gsmedina.receitasApiRest.service

import com.gsmedina.receitasApiRest.dtos.ReceitaDto
import com.gsmedina.receitasApiRest.models.Receita

interface ReceitaService {

    fun buscarPorNome(nome: String): Receita?

    fun salvar(receitaDto: ReceitaDto): Receita

    fun buscarId(id: Long): Receita?

    fun listarTodas(): List<Receita>

    fun listarPorNome(nome: String): Receita?
}