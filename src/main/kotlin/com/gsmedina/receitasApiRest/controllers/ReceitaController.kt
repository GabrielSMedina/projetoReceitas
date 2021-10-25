package com.gsmedina.receitasApiRest.controllers

import com.gsmedina.receitasApiRest.dtos.AtualizacaoDto
import com.gsmedina.receitasApiRest.dtos.ReceitaDto
import com.gsmedina.receitasApiRest.dtos.ReceitaIngredienteDto
import com.gsmedina.receitasApiRest.models.Ingrediente
import com.gsmedina.receitasApiRest.models.Receita
import com.gsmedina.receitasApiRest.models.ReceitaIngrediente
import com.gsmedina.receitasApiRest.models.Unidade
import com.gsmedina.receitasApiRest.response.Response
import com.gsmedina.receitasApiRest.service.IngredienteService
import com.gsmedina.receitasApiRest.service.ReceitaService
import com.gsmedina.receitasApiRest.service.UnidadeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
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

        //Validacao de erros
        if(result.hasErrors()){
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        val lri= mutableListOf<ReceitaIngrediente>()
        val lista: List<ReceitaIngredienteDto> = receitaDto.receitaIngredientes

        var i = 0
        while (receitaDto.receitaIngredientes.size <= i){
            val ri: ReceitaIngrediente? = dtoParaRi(lista[i], receitaDto)
            if (ri != null){
                lri.add(i, ri)
            }else{
                return ResponseEntity.badRequest().body(response)
            }
            i += 1
        }

        //val receita: Receita = dtoParaReceita(receitaDto)
        receitaService.salvar(receitaDto, lri)
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

    @DeleteMapping("/{id}")
    @Transactional
    fun deletar(@PathVariable id: Long){
        receitaService.deletar(id)
    }

    @PutMapping
    @Transactional
    fun atualizar(@RequestBody @Valid atualizacaoDto: AtualizacaoDto, result: BindingResult){
    }

    fun dtoParaRi(receitaIngredienteDto: ReceitaIngredienteDto, receitaDto: ReceitaDto): ReceitaIngrediente?{

        //Como irei achar uma receita q ainda nao foi persistida no banco de dados? primeiro erro.
        //Segundo erro, caso tente adicionar essa receita da q chegou por Dto, terei q converter e novamente entrarei
        // num erro de loop infinito por conta da lista de receitas ingredientes.
        //Posso tentar persistir uma receita com esse id no comedo e depois atualizar ela no banco para ter os itens necessarios
        val receita: Receita? = receitaService.buscarId(receitaIngredienteDto.receita)
        val ingrediente: Ingrediente? = ingredienteService.buscarPorId(receitaIngredienteDto.ingrediente)
        val unidade: Unidade? = unidadeService.buscarPorId(receitaIngredienteDto.unidade)

        if(receita != null && ingrediente != null && unidade != null){
            val ri: ReceitaIngrediente = ReceitaIngrediente(receitaIngredienteDto.quantidadeIngrediente, receita,
                ingrediente, unidade, receitaIngredienteDto.id)
            return ri
        }else{
            return null
        }

    }
}