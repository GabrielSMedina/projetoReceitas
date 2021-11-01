package com.gsmedina.receitasApiRest.service.implements

import com.gsmedina.receitasApiRest.dtos.UnidadeDto
import com.gsmedina.receitasApiRest.models.Unidade
import com.gsmedina.receitasApiRest.repositories.UnidadeRepository
import com.gsmedina.receitasApiRest.service.UnidadeService
import org.springframework.stereotype.Service

@Service
class UnidadeServiceImpl(val unidadeRepository: UnidadeRepository): UnidadeService {
    override fun buscarPorNome(nomeUnidade: String): Unidade? {
        return unidadeRepository.findByNomeUnidade(nomeUnidade)
    }

    override fun salvar(unidadeDto: UnidadeDto): Unidade {
        val unidade: Unidade = Unidade(unidadeDto.nomeUnidade)
        return unidadeRepository.save(unidade)
    }

    override fun listarTodasUnidades(): List<Unidade> {
        return unidadeRepository.findAll()
    }

    override fun buscarPorId(id: Long): Unidade? {
        return unidadeRepository.findById(id).get()
    }

    override fun deletar(id: Long) {
        return unidadeRepository.deleteById(id)
    }

    override fun atualizar(unidadeDto: UnidadeDto, id: Long): Unidade {
        val unidade: Unidade = Unidade(unidadeDto.nomeUnidade, id)
        return unidadeRepository.save(unidade)
    }
}