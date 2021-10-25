package com.gsmedina.receitasApiRest.service

import com.gsmedina.receitasApiRest.dtos.ReceitaDto
import com.gsmedina.receitasApiRest.models.Receita
import com.gsmedina.receitasApiRest.models.ReceitaIngrediente
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

//Interface responsavel por definir os metodos dos nossos servicos utilizados no codigo
interface ReceitaService {

    fun buscarPorNome(nome: String): Receita?

    fun salvar(receitaDto: ReceitaDto, receitaIngrediente: List<ReceitaIngrediente>): Receita

    fun deletar(id: Long)

    fun buscarId(id: Long): Receita?

    fun listarTodas(): List<Receita>

    fun listarPorNome(nome: String): Receita?
}