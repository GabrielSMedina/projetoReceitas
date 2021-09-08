package com.gsmedina.receitasApiRest.service

import com.gsmedina.receitasApiRest.models.Unidade

interface UnidadeService {

    fun buscarPorNome(nomeUnidade: String): Unidade?

    fun salvar(unidade: Unidade): Unidade

    fun listarTodasUnidades(): List<Unidade>?

    fun buscarPorId(id: Long): Unidade?

    fun deletar(id: Long)
}