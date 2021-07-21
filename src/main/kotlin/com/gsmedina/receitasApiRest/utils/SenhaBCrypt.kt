package com.gsmedina.receitasApiRest.utils

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

//Classe para gerar nossa criptografia
class SenhaBCrypt {

    fun gerarBcrypt(senha: String): String = BCryptPasswordEncoder().encode(senha)
}