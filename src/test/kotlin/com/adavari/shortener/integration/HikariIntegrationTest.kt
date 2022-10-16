package com.adavari.shortener.integration

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.sql.DataSource

@SpringBootTest
class HikariIntegrationTest {

    @Autowired private lateinit var dataSource: DataSource

    @Test
    fun hikariConnectionPoolIsConfigured() {
        Assertions.assertEquals("com.zaxxer.hikari.HikariDataSource", dataSource.javaClass.name)
    }

}