package com.adavari.shortener.integration.controller

import com.adavari.shortener.entity.Url
import com.adavari.shortener.hashing.Base64UrlEncoder
import com.adavari.shortener.hashing.MD5
import com.adavari.shortener.repository.UrlRepository
import com.adavari.shortener.testing.SlowTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*


@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@SlowTest
class RedirectControllerTest {

    @Autowired private lateinit var mockMvc: MockMvc
    @Autowired private lateinit var urlRepository: UrlRepository

    @Test
    fun redirectToUrlCorrectly() {
        val id = Base64UrlEncoder(MD5(UUID.randomUUID().toString()).toBytes()).toString().take(7)
        val url = Url(
            id = id,
            url = "https://www.google.com",
            createdAt = LocalDateTime.now(ZoneOffset.UTC)
        )
        urlRepository.save(url)
        mockMvc.perform(
            MockMvcRequestBuilders.get("/${id}"))
            .andExpect(MockMvcResultMatchers.status().isFound)
            .andExpect(MockMvcResultMatchers.header().exists("Location"))
    }



}