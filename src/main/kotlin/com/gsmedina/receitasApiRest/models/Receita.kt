package com.gsmedina.receitasApiRest.models

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name="tb_receitas")
//Classe que criara um modelo de tabela para armazenar no banco de dados
class Receita (
    val nome: String,
    @Column(columnDefinition="TEXT")
    val ingredientes: String,
    @Column(columnDefinition="TEXT")
    val modo_preparo: String,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long
) : Serializable