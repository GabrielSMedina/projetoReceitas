package com.gsmedina.receitasApiRest.Utils

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

class testes {

    val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("receitas")

    val emf: EntityManager = factory.createEntityManager()


}