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


    @OneToMany(mappedBy = "receita", orphanRemoval = true)
    @Cascade(CascadeType.ALL)
    var receitaIngredientes: List<ReceitaIngrediente>,

    @Column(name = "id")
    //Geracao automatica do Id e definicao da Primary Key
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
): Serializable