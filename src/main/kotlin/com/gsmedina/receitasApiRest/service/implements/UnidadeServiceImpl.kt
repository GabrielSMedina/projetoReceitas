package com.gsmedina.receitasApiRest.service.implements

import com.gsmedina.receitasApiRest.models.Unidade
import com.gsmedina.receitasApiRest.repositories.UnidadeRepository
import com.gsmedina.receitasApiRest.service.UnidadeService
import org.springframework.stereotype.Service

@Service
class UnidadeServiceImpl(val unidadeRepository: UnidadeRepository): UnidadeService {
    override fun buscarPorNome(nome: String): Unidade? {
        return unidadeRepository.findByUnidade(nome)
    }

    override fun salvar(unidade: Unidade): Unidade {
        return unidadeRepository.save(unidade)
    }

    override fun listarTodasUnidades(): List<Unidade>? {
        return unidadeRepository.findAll()
    }

    override fun buscarPorId(id: Long): Unidade? {
        return unidadeRepository.findById(id).get()
    }

    override fun deletar(id: Long) {
        return unidadeRepository.deleteById(id)
    }
}