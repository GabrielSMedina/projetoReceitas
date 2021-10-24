package com.gsmedina.receitasApiRest.service

import com.gsmedina.receitasApiRest.dtos.ReceitaDto
import com.gsmedina.receitasApiRest.models.Receita

//Interface responsavel por definir os metodos dos nossos servicos utilizados no codigo
interface ReceitaService {

    fun buscarPorNome(nome: String): Receita?

    fun salvar(receitaDto: ReceitaDto): Receita

    fun deletar(id: Long)

    fun buscarId(id: Long): Receita?

    fun listarTodas(): List<Receita>

    fun listarPorNome(nome: String): Receita?
}