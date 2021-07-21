package com.gsmedina.receitasApiRest.service

import com.gsmedina.receitasApiRest.models.Usuario

//Interface responsavel por definir os metodos dos nossos servicos utilizados no codigo
interface UsuarioService {

    fun salvar(usuario: Usuario): Usuario

    fun buscarNome(nome: String): List<Usuario>

    fun buscarEmail(email: String): Usuario?
}