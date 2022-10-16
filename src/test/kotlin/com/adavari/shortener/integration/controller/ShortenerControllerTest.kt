package com.adavari.shortener.integration.controller

import com.adavari.shortener.dto.UrlDto
import com.adavari.shortener.testing.SlowTest
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@SlowTest
class ShortenerControllerTest {

    @Autowired private lateinit var mockMvc: MockMvc
    @Autowired private lateinit var mapper: ObjectMapper

    @Test
    fun urlShortenedCorrectly() {
        val url = UrlDto("https://www.google.com")
        mockMvc.perform(post("/api/v1/shortening")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsBytes(url)))
            .andExpect(status().isCreated)
    }



}