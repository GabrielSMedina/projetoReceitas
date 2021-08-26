package com.gsmedina.receitasApiRest.service.implements

import com.gsmedina.receitasApiRest.models.Ingrediente
import com.gsmedina.receitasApiRest.repositories.IngredienteRepository
import com.gsmedina.receitasApiRest.service.IngredienteService
import org.springframework.stereotype.Service

@Service
class IngredienteServiceImpl(val ingredienteRepository: IngredienteRepository): IngredienteService {
    override fun buscarPorNome(nomeIngrediente: String): Ingrediente? {
        return ingredienteRepository.findByNomeIngrediente(nomeIngrediente)
    }

    override fun salvar(ingrediente: Ingrediente): Ingrediente {
        return ingredienteRepository.save(ingrediente)
    }

    override fun listarTodas(): List<Ingrediente>? {
        return ingredienteRepository.findAll()
    }

    override fun deletar(id: Long) {
        return ingredienteRepository.deleteById(id)
    }

    override fun buscarPorId(id: Long): Ingrediente? {
        return ingredienteRepository.findById(id).get()
    }

}