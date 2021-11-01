package com.gsmedina.receitasApiRest.response

data class Response<T> (
    val erros: ArrayList<String> = arrayListOf(),
    var data: T? = null
)