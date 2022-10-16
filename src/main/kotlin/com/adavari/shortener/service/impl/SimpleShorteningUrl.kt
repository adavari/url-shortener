package com.adavari.shortener.service.impl

import com.adavari.shortener.entity.Url
import com.adavari.shortener.hashing.Base64UrlEncoder
import com.adavari.shortener.hashing.MD5
import com.adavari.shortener.service.SequenceService
import com.adavari.shortener.service.ShorteningService
import com.adavari.shortener.service.UrlService
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class SimpleShorteningUrl(private val urlService: UrlService, private val sequenceService: SequenceService) :
    ShorteningService {

    override suspend fun shortenUrl(originalUrl: String): Url {
        val nextId = sequenceService.getSequenceNumber()
        val url = Url(
            id = Base64UrlEncoder(MD5(nextId.toString()).toBytes()).toString().take(7),
            url = originalUrl,
            createdAt = LocalDateTime.now(ZoneOffset.UTC)
        )
        return urlService.saveUrl(url)
    }
}