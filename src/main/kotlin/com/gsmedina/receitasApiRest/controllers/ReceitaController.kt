package com.gsmedina.receitasApiRest.controllers

import com.gsmedina.receitasApiRest.dtos.IngredienteDto
import com.gsmedina.receitasApiRest.dtos.JuncaoDto
import com.gsmedina.receitasApiRest.dtos.ReceitaDto
import com.gsmedina.receitasApiRest.dtos.UnidadeDto
import com.gsmedina.receitasApiRest.models.Ingrediente
import com.gsmedina.receitasApiRest.models.Receita
import com.gsmedina.receitasApiRest.models.Unidade
import com.gsmedina.receitasApiRest.response.Response
import com.gsmedina.receitasApiRest.service.IngredienteService
import com.gsmedina.receitasApiRest.service.ReceitaService
import com.gsmedina.receitasApiRest.service.UnidadeService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/receitas")
class ReceitaController(val receitaService: ReceitaService, val ingredienteService: IngredienteService, val unidadeService: UnidadeService) {

    @PostMapping
    fun adicionarReceita(@Valid @RequestBody receitaDto: ReceitaDto, result: BindingResult): ResponseEntity<Response<ReceitaDto>>{
        val response: Response<ReceitaDto> = Response<ReceitaDto>()

        //Validacao de erros
        if(result.hasErrors()){
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        //Cria um objeto do tipo receita para ser persistido no banco de dados
        val receita: Receita = dtoParaReceita(receitaDto, result)
        receitaService.salvar(receita)

        //Cria um objeto que sera retornado para o usuario, sendo este objeto um Dto
        response.data = receitaParaDto(receita)

        return ResponseEntity.ok(response)
    }

    @GetMapping
    fun listarReceitas(): List<Receita>{
        return receitaService.listarTodas()
    }

    fun dtoParaReceita(receitaDto: ReceitaDto, result: BindingResult): Receita = Receita(receitaDto.nomeReceita, receitaDto.minutosPreparo,
    receitaDto.porcoes, receitaDto.modo_preparo, receitaDto.id)

    fun receitaParaDto(receita: Receita): ReceitaDto = ReceitaDto(receita.nomeReceita, receita.minutosPreparo, receita.porcoes,
    receita.modoPreparo, receita.idReceita)
}