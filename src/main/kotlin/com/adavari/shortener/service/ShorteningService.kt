package com.adavari.shortener.service

import com.adavari.shortener.entity.Url


interface ShorteningService {

    suspend fun shortenUrl(originalUrl: String): Url

}