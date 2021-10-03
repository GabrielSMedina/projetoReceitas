package com.gsmedina.receitasApiRest.controllers

import com.gsmedina.receitasApiRest.dtos.IngredienteDto
import com.gsmedina.receitasApiRest.dtos.ReceitaDto
import com.gsmedina.receitasApiRest.dtos.ReceitaIngredienteDto
import com.gsmedina.receitasApiRest.dtos.UnidadeDto
import com.gsmedina.receitasApiRest.models.Ingrediente
import com.gsmedina.receitasApiRest.models.Receita
import com.gsmedina.receitasApiRest.models.ReceitaIngrediente
import com.gsmedina.receitasApiRest.models.Unidade
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
    fun relacionarDados(@Valid @RequestBody receitaIngredienteDto: ReceitaIngredienteDto, result: BindingResult):
            ResponseEntity<Response<ReceitaIngredienteDto>>{

        val response: Response<ReceitaIngredienteDto> = Response<ReceitaIngredienteDto>()

        if(result.hasErrors()){
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        val receita: Receita = dtoParaReceita(receitaIngredienteDto.receita)
        val ingrediente : Ingrediente = dtoParaIngrediente(receitaIngredienteDto.ingrediente)
        val unidade: Unidade = dtoParaUnidade(receitaIngredienteDto.unidade)

        //Cria um objeto do tipo receitaIngrediente para ser persistido no banco de dados
        val receitaIngrediente: ReceitaIngrediente = dtoParaReceitaIngrediente(receitaIngredienteDto, receita, ingrediente, unidade, result)
        receitaIngredienteService.salvar(receitaIngrediente)

        //Cria um objeto que sera retornado para o usuario, sendo este objeto um Dto
        //response.data = receitaIngredienteParaDto(receitaIngrediente)

        response.data = receitaIngredienteDto

        return ResponseEntity.ok(response)
    }

    fun dtoParaReceitaIngrediente(receitaIngredienteDto: ReceitaIngredienteDto, receita: Receita, ingrediente: Ingrediente,
                                  unidade: Unidade, result: BindingResult): ReceitaIngrediente =
        ReceitaIngrediente(receitaIngredienteDto.quantidadeIngrediente, receita, ingrediente, unidade, receitaIngredienteDto.id)

//    fun receitaIngredienteParaDto(receitaIngrediente: ReceitaIngrediente): ReceitaIngredienteDto = ReceitaIngredienteDto(
//        receitaIngrediente.quantidadeIngrediente, receitaIngrediente.receita, receitaIngrediente.ingrediente,
//        receitaIngrediente.unidade, receitaIngrediente.id)

    fun dtoParaReceita(receita: ReceitaDto): Receita = Receita(receita.nomeReceita, receita.minutosPreparo, receita.porcoes,
    receita.modoPreparo, receita.receitaIngredientes, receita.id)

    fun dtoParaIngrediente(ingrediente: IngredienteDto): Ingrediente = Ingrediente(ingrediente.nomeIngrediente, ingrediente.id)

    fun dtoParaUnidade(unidade: UnidadeDto): Unidade = Unidade(unidade.nomeUnidade, unidade.id)
}