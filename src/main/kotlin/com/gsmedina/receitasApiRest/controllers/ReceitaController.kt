package com.gsmedina.receitasApiRest.controllers

import com.gsmedina.receitasApiRest.dtos.IngredienteDto
import com.gsmedina.receitasApiRest.dtos.ReceitaDto
import com.gsmedina.receitasApiRest.dtos.UnidadeDto
import com.gsmedina.receitasApiRest.response.Response
import com.gsmedina.receitasApiRest.service.ReceitaService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/receita")
class ReceitaController(val receitaService: ReceitaService) {

//    @PostMapping
//    fun adicionarReceita(@Valid @RequestBody ingredienteDto: IngredienteDto, receitaDto: ReceitaDto,
//                         unidadeDto: UnidadeDto, result: BindingResult): ResponseEntity<Response<ReceitaDto>>{
//
//    }
}