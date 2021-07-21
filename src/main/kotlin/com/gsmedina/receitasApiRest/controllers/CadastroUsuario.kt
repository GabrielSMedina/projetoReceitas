package com.gsmedina.receitasApiRest.controllers

import com.gsmedina.receitasApiRest.dtos.UsuarioDto
import com.gsmedina.receitasApiRest.enums.PerfilEnum
import com.gsmedina.receitasApiRest.models.Usuario
import com.gsmedina.receitasApiRest.response.Response
import com.gsmedina.receitasApiRest.service.UsuarioService
import com.gsmedina.receitasApiRest.utils.SenhaBCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/cadastrar")
class CadastroUsuario {
    //Receibe os dados de um usuario para criar um novo usuario e persistir ele no banco de dados
    @PostMapping
    fun cadastrar(@Valid @RequestBody usuarioDto: UsuarioDto,
                  result: BindingResult): ResponseEntity<Response<UsuarioDto>> {
        //Cria um objeto de response para receber os dados do usuario e armazenar seus possiveis erros
        val response: Response<UsuarioDto> = Response<UsuarioDto>()
            validarDadosExistentes(usuarioDto, result)

        //Faz uma verificacao de erros e os lista para o usuario caso existam
        if (result.hasErrors()) {
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        val usuario:Usuario = criarUsuario(usuarioDto)
        usuarioService.salvar(usuario)

        response.data = criarUsuarioDto(usuario)

        return ResponseEntity.ok(response)
    }

    //faz a injecao de usuarioService na classe
    @Autowired
    internal lateinit var usuarioService: UsuarioService

    private fun validarDadosExistentes(usuarioDto: UsuarioDto, result: BindingResult) {
        val usuarioEmail: Usuario? = usuarioService.buscarEmail(usuarioDto.email)
        if (usuarioEmail != null) {
            result.addError(ObjectError("usuario", "Email já existente."))
        }
    }

    fun criarUsuario(usuarioDto: UsuarioDto) = Usuario(usuarioDto.nome, usuarioDto.email,
        SenhaBCrypt().gerarBcrypt(usuarioDto.senha), PerfilEnum.ROLE_USUARIO, usuarioDto.id)

    fun criarUsuarioDto(usuario: Usuario): UsuarioDto = UsuarioDto(usuario.nome, usuario.email, "", usuario.id)
}