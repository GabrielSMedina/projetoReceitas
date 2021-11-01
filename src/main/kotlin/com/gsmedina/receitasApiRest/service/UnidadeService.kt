package com.gsmedina.receitasApiRest.service

import com.gsmedina.receitasApiRest.dtos.UnidadeDto
import com.gsmedina.receitasApiRest.models.Unidade

interface UnidadeService {

    fun buscarPorNome(nomeNomeUnidade: String): Unidade?

    fun salvar(unidadeDto: UnidadeDto): Unidade

    fun listarTodasUnidades(): List<Unidade>

    fun buscarPorId(id: Long): Unidade?

    fun deletar(id: Long)

    fun atualizar(unidadeDto: UnidadeDto, id: Long): Unidade
}