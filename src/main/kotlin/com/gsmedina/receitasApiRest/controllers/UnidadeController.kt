package com.gsmedina.receitasApiRest.controllers

import com.gsmedina.receitasApiRest.Views.UnidadeView
import com.gsmedina.receitasApiRest.dtos.UnidadeDto
import com.gsmedina.receitasApiRest.models.Unidade
import com.gsmedina.receitasApiRest.response.Response
import com.gsmedina.receitasApiRest.service.UnidadeService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/unidade")
class UnidadeController(val unidadeService: UnidadeService) {

    @GetMapping
    fun mostrarUnidades(): List<Unidade>{
        return unidadeService.listarTodasUnidades()
    }

    @PostMapping
    fun adicionarUndiade(@RequestBody @Valid unidadeDto: UnidadeDto, result: BindingResult):
            ResponseEntity<Response<UnidadeView>>{
        val response: Response<UnidadeView> = Response<UnidadeView>()

        if(result.hasErrors()){
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        val unidade: Unidade =unidadeService.salvar(unidadeDto)

        response.data = UnidadeView(unidadeDto.nomeUnidade, unidade.id)

        return ResponseEntity.ok(response)
    }

    @PutMapping("/{id}")
    fun atualizarUnidade(@RequestBody @Valid unidadeDto: UnidadeDto, @PathVariable id:Long, result: BindingResult):
            ResponseEntity<Response<UnidadeView>>{
        val response: Response<UnidadeView> = Response<UnidadeView>()

        if(result.hasErrors()){
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        unidadeService.atualizar(unidadeDto, id)
        val view: UnidadeView = UnidadeView(unidadeDto.nomeUnidade, id)
        response.data = view

        return ResponseEntity.ok(response)
    }


    @DeleteMapping("/{id}")
    fun deletarUndiade(@PathVariable @Valid id: Long){
        unidadeService.deletar(id)
    }
}