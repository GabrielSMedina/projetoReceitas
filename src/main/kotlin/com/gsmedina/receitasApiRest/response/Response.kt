package com.gsmedina.receitasApiRest.response

//Classe para armazenar qualquer tipo de objeto e uma lista de erros
data class Response<T> (
    val erros: ArrayList<String> = arrayListOf(),
    var data: T? = null
)