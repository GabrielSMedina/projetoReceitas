package com.gsmedina.receitasApiRest.service.implements

import com.gsmedina.receitasApiRest.models.Receita
import com.gsmedina.receitasApiRest.repositories.ReceitaRepository
import com.gsmedina.receitasApiRest.service.ReceitaService
import org.springframework.stereotype.Service

//Classe responsavel por implementar os servicos de nossa interface de servicos
@Service
class ReceitaServiceImpl(val receitaRepository: ReceitaRepository): ReceitaService {

    override fun buscarPorNome(nome: String): Receita? {
        return receitaRepository.findByNome(nome)
    }

    override fun salvar(receita: Receita): Receita {
        return receitaRepository.save(receita)
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
        return receitaRepository.findByNome(nome)
    }

}