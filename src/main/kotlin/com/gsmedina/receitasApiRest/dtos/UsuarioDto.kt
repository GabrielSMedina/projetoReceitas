package com.gsmedina.receitasApiRest.dtos

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

//Classe para transferir dados entre os sub-sistemas do codigo
class UsuarioDto (
    @get:NotEmpty(message = "Nome obrigatório")
    @get:Length(min = 1, max = 255, message = "Nome deve conter entre 3 e 200 caracteres.")
    val nome: String = "",

    @get:NotEmpty(message = "Email obrigatório")
    @get:Length(min = 5, max = 255, message = "Email deve conter entre 5 e 200 caracteres.")
    @get:Email(message="Email inválido.")
    val email: String = "",

    @get:NotEmpty(message = "Senha não pode ser vazia.")
    val senha: String = "",

    val id: Long
)