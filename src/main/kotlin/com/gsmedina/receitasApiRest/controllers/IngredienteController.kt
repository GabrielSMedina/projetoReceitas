package com.gsmedina.receitasApiRest.controllers

import com.gsmedina.receitasApiRest.Views.IngredienteView
import com.gsmedina.receitasApiRest.dtos.IngredienteDto
import com.gsmedina.receitasApiRest.models.Ingrediente
import com.gsmedina.receitasApiRest.response.Response
import com.gsmedina.receitasApiRest.service.IngredienteService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api/ingrediente")
class IngredienteController (val ingredienteService: IngredienteService){

    @GetMapping
    fun mostrarTodos():List<Ingrediente>{
        return ingredienteService.listarTodosIngredientes()
    }

    @PostMapping
    fun adicionarIngrediente(@RequestBody @Valid ingredienteDto: IngredienteDto, result: BindingResult):
            ResponseEntity<Response<IngredienteView>>{
        val response: Response<IngredienteView> = Response<IngredienteView>()

        if(result.hasErrors()){
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        val ingrediente: Ingrediente = ingredienteService.salvar(ingredienteDto.nomeIngrediente)

        val view: IngredienteView = IngredienteView(ingrediente.nomeIngrediente, ingrediente.id)
        response.data = view
        return ResponseEntity.ok(response)
    }

    @PutMapping("/{id}")
    fun atualizarIngrediente(@RequestBody @Valid ingredienteDto: IngredienteDto, @PathVariable id: Long,
                             result: BindingResult): ResponseEntity<Response<IngredienteView>>{
        val response: Response<IngredienteView> = Response<IngredienteView>()

        if(result.hasErrors()){
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        val ingrediente: Ingrediente = ingredienteService.atualizar(ingredienteDto, id)
        val view: IngredienteView = IngredienteView(ingrediente.nomeIngrediente, ingrediente.id)
        response.data = view
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/{id}")
    fun deletarIngrediente(@PathVariable @Valid id: Long){
        return ingredienteService.deletar(id)
    }
}