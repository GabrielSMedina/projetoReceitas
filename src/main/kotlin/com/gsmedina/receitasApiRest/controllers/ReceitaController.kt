package com.gsmedina.receitasApiRest.controllers

import com.gsmedina.receitasApiRest.dtos.ReceitaDto
import com.gsmedina.receitasApiRest.models.Receita
import com.gsmedina.receitasApiRest.response.Response
import com.gsmedina.receitasApiRest.service.ReceitaService
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/receitas")
class ReceitaController (val receitaService: ReceitaService){

    //Metodo para adicionar receitas
    @PostMapping("/adicionar")
    fun adicionarReceita(@Valid @RequestBody receitaDto: ReceitaDto, result: BindingResult): ResponseEntity<Response<ReceitaDto>>{
        val response: Response<ReceitaDto> = Response<ReceitaDto>()
        validarDadosExistentes(receitaDto, result)

        //Validacao de erros, checa se os campos foram preenchidos como explicitado na classe dto
        if (result.hasErrors()) {
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }
        //Cria um objeto do tipo receita para que seja persistido no banco de dados
        val receita: Receita = DtoParaReceita(receitaDto, result)
        receitaService.salvar(receita)
        //Cria um objeto dto para q ele seja retornado para o usuario
        response.data = ReceitaParaDto(receita)
        return ResponseEntity.ok(response)
    }


    private fun validarDadosExistentes(receitaDto: ReceitaDto, result: BindingResult) {
        val receitaNome: Receita? = receitaService.buscarPorNome(receitaDto.nome)
        if (receitaNome != null) {
            result.addError(ObjectError("receita", "Receita já existente."))
        }
    }

    //Metodo para atualizar receitas
    @PutMapping("/atualizar")
    fun atualizarReceita(@Valid @RequestBody receitaDto: ReceitaDto, result: BindingResult): ResponseEntity<Response<ReceitaDto>>{
        val response: Response<ReceitaDto> = Response<ReceitaDto>()

        if (result.hasErrors()) {
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }
        val receita: Receita = DtoParaReceita(receitaDto, result)
        receitaService.salvar(receita)
        response.data = ReceitaParaDto(receita)
        return ResponseEntity.ok(response)
    }

//    //Metodo para deletar por nome
//    @DeleteMapping("/deletar/{nome}")
//    fun deletar(@PathVariable("nome") nome: String): ResponseEntity<Response<String>> {
//
//        val response: Response<String> = Response<String>()
//        val receita: Receita? = receitaService.buscarPorNome(nome)
//
//        if (receita == null) {
//            response.erros.add("Não foi possivel remover a receita pois o registro nao foi encontrado")
//            return ResponseEntity.badRequest().body(response)
//        }
//        val id = receita.id
//        receitaService.deletar(id)
//        return ResponseEntity.ok(Response<String>())
//    }

    //Metodo para deletar receitas do banco de dados
    @DeleteMapping("/deletar/{id}")
    fun deletar(@PathVariable("id") id: Long): ResponseEntity<Response<Long>> {
        val response: Response<Long> = Response<Long>()
        val receita: Receita? = receitaService.buscarId(id)

        if (receita == null) {
            response.erros.add("Não foi possivel remover a receita pois o registro nao foi encontrado")
            return ResponseEntity.badRequest().body(response)
        }

        receitaService.deletar(id)
        return ResponseEntity.ok(Response<Long>())
    }

    //Metodo para listar todas as receitas
    @GetMapping("/listar")
    fun listar(): List<Receita>{
        return receitaService.listarTodas()
    }

    //Metodo para buscar uma receita pelo seu id
    @GetMapping("/buscar/{id}")
    fun receitaPorid(@PathVariable("id") id: Long): ResponseEntity<Response<Receita>> {

        val response: Response<Receita> = Response<Receita>()
        val receita: Receita? = receitaService.buscarId(id)

        if(receita == null){
            response.erros.add("Não foi encontrada nenhuma receita com este id")
            return ResponseEntity.badRequest().body(response)
        }

        response.data = receita
        return ResponseEntity.ok(response)
    }

    private fun ReceitaParaDto(receita: Receita): ReceitaDto = ReceitaDto(receita.nome, receita.ingredientes, receita.modo_preparo, receita.id)

    private fun DtoParaReceita(receitaDto: ReceitaDto, result: BindingResult):Receita = Receita(receitaDto.nome, receitaDto.ingredientes, receitaDto.modo_preparo, receitaDto.id)
}