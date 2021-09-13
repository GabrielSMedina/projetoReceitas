package com.gsmedina.receitasApiRest.controllers

import com.gsmedina.receitasApiRest.dtos.UnidadeDto
import com.gsmedina.receitasApiRest.models.Unidade
import com.gsmedina.receitasApiRest.response.Response
import com.gsmedina.receitasApiRest.service.UnidadeService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/unidades")
class UnidadeController(val unidadeService: UnidadeService) {

    @PostMapping
    fun adicionarUnidade(@Valid @RequestBody  unidadeDto: UnidadeDto, result: BindingResult): ResponseEntity<Response<UnidadeDto>>{
        val response: Response<UnidadeDto> = Response<UnidadeDto>()
        validarUnidade(unidadeDto, result)

        if(result.hasErrors()){
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        val unidade: Unidade = dtoParaUnidade(unidadeDto, result)
        unidadeService.salvar(unidade)

        response.data = unidadeParaDto(unidade)

        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/{id}")
    fun deletarIngrediente(@PathVariable("id") id: Long): ResponseEntity<Response<Long>>{
        val response: Response<Long> = Response<Long>()
        val unidade: Unidade? = unidadeService.buscarPorId(id)

        if(unidade == null){
            response.erros.add("Não foi possivel remover a unidade pois o registro nao foi encontrado")
            return ResponseEntity.badRequest().body(response)
        }

        unidadeService.deletar(id)
        return ResponseEntity.ok(Response<Long>())
    }

    @GetMapping
    fun listarUnidades(): List<Unidade>? {
        return unidadeService.listarTodasUnidades()
    }

    fun validarUnidade(unidadeDto: UnidadeDto, result: BindingResult){
        val unidadeNome: Unidade? = unidadeService.buscarPorNome(unidadeDto.nomeUnidade)

        if(unidadeNome != null){
            result.addError(ObjectError("Unidades", "Unidade nao encontrada"))
        }
    }

    fun dtoParaUnidade(unidadeDto: UnidadeDto, result: BindingResult): Unidade = Unidade(unidadeDto.nomeUnidade, unidadeDto.id)

    fun unidadeParaDto(unidade: Unidade): UnidadeDto = UnidadeDto(unidade.nomeUnidade, unidade.id)
}