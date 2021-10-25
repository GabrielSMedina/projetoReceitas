//package com.gsmedina.receitasApiRest.Utils
//
//import com.gsmedina.receitasApiRest.dtos.ReceitaIngredienteDto
//import com.gsmedina.receitasApiRest.models.Ingrediente
//import com.gsmedina.receitasApiRest.models.Receita
//import com.gsmedina.receitasApiRest.models.ReceitaIngrediente
//import com.gsmedina.receitasApiRest.models.Unidade
//import com.gsmedina.receitasApiRest.service.IngredienteService
//import com.gsmedina.receitasApiRest.service.ReceitaService
//import com.gsmedina.receitasApiRest.service.UnidadeService
//
//class Conversor(val receitaService: ReceitaService, val ingredienteService: IngredienteService,
//                val unidadeService: UnidadeService) {
//
//    fun dtoParaRi(receitaIngredienteDto: ReceitaIngredienteDto): ReceitaIngrediente{
//
//        val receita: Receita? = receitaService.buscarId(receitaIngredienteDto.receita)
//        val ingrediente:Ingrediente? = ingredienteService.buscarPorId(receitaIngredienteDto.ingrediente)
//        val unidade: Unidade? = unidadeService.buscarPorId(receitaIngredienteDto.unidade)
//
//        if(receita != null && ingrediente != null && unidade != null){
//            val ri: ReceitaIngrediente = ReceitaIngrediente(receitaIngredienteDto.quantidadeIngrediente, receita,
//                ingrediente, unidade, receitaIngredienteDto.id)
//            return ri
//        }
//        else{
//            val ri: ReceitaIngrediente = ReceitaIngrediente()
//
//            return ri
//        }
//    }
//}


//    private fun dtoParaReceita(receitaDto: ReceitaDto): Receita {
//        val ri: List<ReceitaIngrediente> = DtoParaRi(receitaDto.receitaIngredientes)
//        return Receita(receitaDto.nomeReceita, receitaDto.minutosPreparo, receitaDto.porcoes, receitaDto.modoPreparo,
//            ri, receitaDto.id)
//    }
//
//    private fun DtoParaRi(receitaIngredienteDto: List<ReceitaIngredienteDto>): List<ReceitaIngrediente>{
//        return List<ReceitaIngrediente>(receitaIngredienteDto)
//    }