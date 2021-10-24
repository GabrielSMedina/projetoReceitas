package com.gsmedina.receitasApiRest.controllers

import com.gsmedina.receitasApiRest.dtos.ReceitaDto
import com.gsmedina.receitasApiRest.dtos.ReceitaIngredienteDto
import com.gsmedina.receitasApiRest.models.Receita
import com.gsmedina.receitasApiRest.models.ReceitaIngrediente
import com.gsmedina.receitasApiRest.response.Response
import com.gsmedina.receitasApiRest.service.ReceitaService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/receita")
class ReceitaController (val receitaService: ReceitaService) {

    @PostMapping
    fun adicionar(@Valid @RequestBody receitaDto: ReceitaDto, result: BindingResult): ResponseEntity<Response<ReceitaDto>>{
        val response: Response<ReceitaDto> = Response<ReceitaDto>()

        //Validacao de erros
        if(result.hasErrors()){
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        val receita: Receita = dtoParaReceita(receitaDto)
        receitaService.salvar(receita)

        response.data = receitaDto

        return ResponseEntity.ok(response)
    }

    @GetMapping
    fun mostrar(){

    }

    @DeleteMapping
    fun deletar(){

    }

    @PutMapping
    fun atualizar(){

    }

    private fun dtoParaReceita(receitaDto: ReceitaDto): Receita {
        val ri: List<ReceitaIngrediente> = DtoParaRi(receitaDto.receitaIngredientes)
        return Receita(receitaDto.nomeReceita, receitaDto.minutosPreparo, receitaDto.porcoes, receitaDto.modoPreparo,
            ri, receitaDto.id)
    }

    private fun DtoParaRi(receitaIngredienteDto: List<ReceitaIngredienteDto>): List<ReceitaIngrediente>{
        return List<ReceitaIngrediente>(receitaIngredienteDto)
    }
}