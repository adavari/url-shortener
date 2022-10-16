package com.adavari.shortener.controller

import com.adavari.shortener.dto.ShortenedUrlResponse
import com.adavari.shortener.dto.UrlDto
import com.adavari.shortener.service.ShorteningService
import org.springframework.stereotype.Controller

@Controller
class ShortenerController(private val shorteningService: ShorteningService) : ShortenerApi {

    override suspend fun shortUrl(urlDto: UrlDto): ShortenedUrlResponse {
        val url = shorteningService.shortenUrl(urlDto.url)
        return ShortenedUrlResponse(shortenedUrl = url.id, originalUrl = url.url)
    }
}