package com.adavari.shortener.service.impl

import com.adavari.shortener.entity.Url
import com.adavari.shortener.exception.UrlNotFoundException
import com.adavari.shortener.repository.UrlRepository
import com.adavari.shortener.service.UrlService
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class SimpleUrlService(private val urlRepository: UrlRepository) : UrlService {

    override suspend fun saveUrl(url: Url): Url {
        return urlRepository.save(url)
    }

    @Cacheable(value = ["urlCache"])
    override suspend fun getUrl(shortenedUrl: String): Url {
        return urlRepository.findById(shortenedUrl).orElseThrow { UrlNotFoundException("$shortenedUrl not found!") }
    }
}