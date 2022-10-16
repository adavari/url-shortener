package com.adavari.shortener.controller

import com.adavari.shortener.dto.ShortenedUrlResponse
import com.adavari.shortener.dto.UrlDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController()
@RequestMapping("/api/v1/shortening")
interface ShortenerApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun shortUrl(@Valid @RequestBody urlDto: UrlDto): ShortenedUrlResponse

}