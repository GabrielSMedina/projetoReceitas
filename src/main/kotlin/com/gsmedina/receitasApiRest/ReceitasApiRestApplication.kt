package com.gsmedina.receitasApiRest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource


@SpringBootApplication
class ReceitasApiRestApplication

fun main(args: Array<String>) {
	runApplication<ReceitasApiRestApplication>(*args)
}

//@Bean
//fun dataSource(): DataSource? {
//	val dataSource = DriverManagerDataSource()
//	dataSource.setDriverClassName("org.postgresql:postgresql")
//	dataSource.url = "jdbc:postgresql://localhost/db_receitas?useSSL=false"
//	dataSource.username = "medina"
//	dataSource.password = "1378563"
//	return dataSource
//}