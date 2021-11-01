package com.gsmedina.receitasApiRest.service.implements

import com.gsmedina.receitasApiRest.dtos.ReceitaDto
import com.gsmedina.receitasApiRest.dtos.ReceitaIngredienteDto
import com.gsmedina.receitasApiRest.models.Receita
import com.gsmedina.receitasApiRest.models.ReceitaIngrediente
import com.gsmedina.receitasApiRest.repositories.ReceitaRepository
import com.gsmedina.receitasApiRest.service.IngredienteService
import com.gsmedina.receitasApiRest.service.ReceitaService
import com.gsmedina.receitasApiRest.service.UnidadeService
import org.springframework.stereotype.Service


@Service
class ReceitaServiceImpl(val receitaRepository: ReceitaRepository, val unidadeService: UnidadeService,
        val ingredienteService: IngredienteService): ReceitaService {

    override fun buscarPorNome(nome: String): Receita? {
        return receitaRepository.findByNomeReceita(nome)
    }

    override fun salvar(receitaDto: ReceitaDto): Receita {

        val receita = Receita(receitaDto.nomeReceita, receitaDto.minutosPreparo, receitaDto.porcoes,
            receitaDto.modoPreparo, converteReceitaIngrediente(receitaDto.receitaIngredientes))


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
        return receitaRepository.findByNomeReceita(nome)
    }

    private fun converteReceitaIngrediente(receitaIngredienteDto: List<ReceitaIngredienteDto>): List<ReceitaIngrediente>{
        val lri= mutableListOf<ReceitaIngrediente>()


        receitaIngredienteDto.forEach{

            val idIng = ingredienteService.buscarPorNome(it.ingrediente.nomeIngrediente)
            if(idIng == null){
                ingredienteService.salvar(it.ingrediente.nomeIngrediente)
            }

            lri += ReceitaIngrediente(quantidadeIngrediente = it.quantidadeIngrediente,
                ingredienteService.buscarPorNome(it.ingrediente.nomeIngrediente), unidadeService.buscarPorId(it.unidade))
        }

        return lri
    }
}