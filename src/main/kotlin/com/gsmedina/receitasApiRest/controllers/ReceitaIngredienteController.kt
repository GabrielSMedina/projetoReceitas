package com.gsmedina.receitasApiRest.controllers

import com.gsmedina.receitasApiRest.dtos.ReceitaIngredienteDto
import com.gsmedina.receitasApiRest.models.ReceitaIngrediente
import com.gsmedina.receitasApiRest.response.Response
import com.gsmedina.receitasApiRest.service.ReceitaIngredienteService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/receitaingrediente")
class ReceitaIngredienteController(val receitaIngredienteService: ReceitaIngredienteService) {

    @PostMapping
    fun relacionarDados(@Valid @RequestBody receitaIngredienteDto: ReceitaIngredienteDto, result: BindingResult): ResponseEntity<Response<ReceitaIngredienteDto>>{
        val response: Response<ReceitaIngredienteDto> = Response<ReceitaIngredienteDto>()

        if(result.hasErrors()){
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        //Cria um objeto do tipo receitaIngrediente para ser persistido no banco de dados
        val receitaIngrediente: ReceitaIngrediente = dtoParaReceita(receitaIngredienteDto, result)
        receitaIngredienteService.salvar(receitaIngrediente)

        //Cria um objeto que sera retornado para o usuario, sendo este objeto um Dto
        response.data = receitaParaDto(receitaIngrediente)

        return ResponseEntity.ok(response)
    }

    fun dtoParaReceita(receitaIngredienteDto: ReceitaIngredienteDto, result: BindingResult):
            ReceitaIngrediente = ReceitaIngrediente(receitaIngredienteDto.quantidadeIngrediente, receitaIngredienteDto.idReceita,
    receitaIngredienteDto.idIngrediente, receitaIngredienteDto.idUnidade, receitaIngredienteDto.id)

    fun receitaParaDto(receitaIngrediente: ReceitaIngrediente): ReceitaIngredienteDto = ReceitaIngredienteDto(receitaIngrediente.quantidadeIngrediente,
    receitaIngrediente.idReceita, receitaIngrediente.idIngrediente, receitaIngrediente.idUnidade, receitaIngrediente.idRecietaIngrediente)
}