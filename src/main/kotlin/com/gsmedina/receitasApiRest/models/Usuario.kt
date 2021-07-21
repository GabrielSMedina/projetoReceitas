package com.gsmedina.receitasApiRest.models

import com.gsmedina.receitasApiRest.enums.PerfilEnum
import javax.persistence.*

@Entity
@Table(name = "tb_usuario")
//Classe que criara um modelo de tabela para armazenar no banco de dados
data class Usuario (
    val nome: String,

    @Column(unique = true)
    val email: String,

    val senha: String,
    val perfil: PerfilEnum,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long
        )