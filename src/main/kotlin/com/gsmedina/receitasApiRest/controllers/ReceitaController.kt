package com.gsmedina.receitasApiRest.controllers

import com.gsmedina.receitasApiRest.dtos.ReceitaDto
import com.gsmedina.receitasApiRest.models.Receita
import com.gsmedina.receitasApiRest.response.Response
import com.gsmedina.receitasApiRest.service.IngredienteService
import com.gsmedina.receitasApiRest.service.ReceitaService
import com.gsmedina.receitasApiRest.service.UnidadeService
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/receita")
class ReceitaController (val receitaService: ReceitaService, val ingredienteService: IngredienteService,
                         val unidadeService: UnidadeService) {

    @PostMapping
    @Transactional
    fun adicionar(@Valid @RequestBody receitaDto: ReceitaDto, result: BindingResult):
            ResponseEntity<Response<ReceitaDto>>{
        val response: Response<ReceitaDto> = Response<ReceitaDto>()

        if(result.hasErrors()){
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        receitaService.salvar(receitaDto)
        response.data = receitaDto
        return ResponseEntity.ok(response)
    }

    @GetMapping
    fun mostrar(): List<Receita> {
        return receitaService.listarTodas()
    }

    @GetMapping("/{id}")
    fun buscar(@PathVariable id:Long): Receita?{
        return receitaService.buscarId(id)
    }

}