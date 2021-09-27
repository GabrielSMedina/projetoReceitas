package com.gsmedina.receitasApiRest.service.implements

import com.gsmedina.receitasApiRest.models.ReceitaIngrediente
import com.gsmedina.receitasApiRest.repositories.ReceitaIngredienteRepository
import com.gsmedina.receitasApiRest.service.ReceitaIngredienteService
import org.springframework.stereotype.Service

@Service
class ReceitaIngredienteServiceImpl(val receitaIngredienteRepository: ReceitaIngredienteRepository): ReceitaIngredienteService {
    override fun salvar(receitaIngrediente: ReceitaIngrediente): ReceitaIngrediente {
        return receitaIngredienteRepository.save(receitaIngrediente)
    }

    override fun buscarPorId(id: Long): ReceitaIngrediente? {
        return receitaIngredienteRepository.findByid(id)
    }
}