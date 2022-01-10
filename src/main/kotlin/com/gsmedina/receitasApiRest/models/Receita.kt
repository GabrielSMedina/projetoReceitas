package com.gsmedina.receitasApiRest.models

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "receitas")
class Receita(
    @Column(name = "nome_receita")
    var nomeReceita: String,

    @Column(name = "minutos_preparo")
    var minutosPreparo: Int,

    var porcoes: Int,

    @Column(name = "modo_preparo")
    var modoPreparo: String,


    @OneToMany
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "id_receita")
    var receitaIngredientes: List<ReceitaIngrediente>,

    @Column(name = "id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
): Serializable