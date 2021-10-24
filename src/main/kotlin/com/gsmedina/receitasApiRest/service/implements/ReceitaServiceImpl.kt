package com.gsmedina.receitasApiRest.service.implements

import com.gsmedina.receitasApiRest.dtos.ReceitaDto
import com.gsmedina.receitasApiRest.models.Receita
import com.gsmedina.receitasApiRest.repositories.ReceitaRepository
import com.gsmedina.receitasApiRest.service.ReceitaService
import org.springframework.stereotype.Service

//Classe responsavel por implementar os servicos de nossa interface de servicos
@Service
class ReceitaServiceImpl(val receitaRepository: ReceitaRepository): ReceitaService {

    override fun buscarPorNome(nome: String): Receita? {
        return receitaRepository.findByNomeReceita(nome)
    }

    override fun salvar(receitaDto: ReceitaDto): Receita {
        return receitaRepository.save(Receita(
            receitaDto.nomeReceita, receitaDto.minutosPreparo, receitaDto.porcoes, receitaDto.modoPreparo,
            receitaDto.receitaIngredientes, receitaDto.id
        ))
    }

    override fun deletar(id: Long) {
        receitaRepository.deleteById(id)
    }

    override fun buscarId(id: Long): Receita? {
        return receitaRepository.findById(id).get()
    }

    override fun listarTodas(): List<Receita> {
        return receitaRepository.findAll()
    }

    override fun listarPorNome(nome: String): Receita? {
        return receitaRepository.findByNomeReceita(nome)
    }

}