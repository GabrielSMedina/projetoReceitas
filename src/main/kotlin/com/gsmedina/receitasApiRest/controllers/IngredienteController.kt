package com.gsmedina.receitasApiRest.controllers

import com.gsmedina.receitasApiRest.dtos.IngredienteDto
import com.gsmedina.receitasApiRest.models.Ingrediente
import com.gsmedina.receitasApiRest.response.Response
import com.gsmedina.receitasApiRest.service.IngredienteService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/ingrediente")
class IngredienteController(val ingredienteService: IngredienteService) {

    //Metodo para adicionar ingrediente
    @PostMapping
    fun adicionarIngrediente(@Valid @RequestBody ingredienteDto: IngredienteDto, result: BindingResult): ResponseEntity<Response<IngredienteDto>>{
        val response: Response<IngredienteDto> = Response<IngredienteDto>()
        validarIngrediente(ingredienteDto, result)

        //Validacao de erros
        if(result.hasErrors()){
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        //Cria um objeto do tipo Ingrediente para ser persistido no banco de dados
        val ingrediente: Ingrediente = dtoParaIngrediente(ingredienteDto, result)
        ingredienteService.salvar(ingrediente)

        //Cria um objeto que sera retornado para o usuario, sendo este objeto um Dto
        response.data = ingredienteParaDto(ingrediente)

        return ResponseEntity.ok(response)
    }

    //Funcao para checar se existe um ingrediente com o mesmo nome
    fun validarIngrediente(ingredienteDto: IngredienteDto, result: BindingResult){
        val ingredienteNome: Ingrediente? = ingredienteService.buscarPorNome(ingredienteDto.nomeIngrediente)

        if(ingredienteNome != null){
            result.addError(ObjectError("ingrediente", "Ingrediente Ja existente"))
        }
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable("id") id: Long): ResponseEntity<Response<Long>>{
        val response: Response<Long> = Response<Long>()
        val ingrediente: Ingrediente? = ingredienteService.buscarPorId(id)

        if(ingrediente == null){
            response.erros.add("Não foi possivel remover o ingrediente pois o registro nao foi encontrado")
            return ResponseEntity.badRequest().body(response)
        }

        ingredienteService.deletar(id)
        return ResponseEntity.ok(Response<Long>())
    }

    //Metodo para listar todos os ingredientes existente dno banco de dados
    @GetMapping
    fun listar(): List<Ingrediente>?{
        return ingredienteService.listarTodas()
    }

    //Funcao para transformar um IngredienteDto em um Ingrediente
    fun dtoParaIngrediente(ingredienteDto: IngredienteDto, result: BindingResult): Ingrediente = Ingrediente(ingredienteDto.nomeIngrediente, ingredienteDto.idIngrediente)

    //Funcao para transformar um Ingrediente em um IngredieneteDto
    fun ingredienteParaDto(ingrediente: Ingrediente): IngredienteDto = IngredienteDto(ingrediente.nomeIngrediente, ingrediente.idIngrediente)

}