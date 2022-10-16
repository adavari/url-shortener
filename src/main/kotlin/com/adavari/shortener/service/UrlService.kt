package com.adavari.shortener.service

import com.adavari.shortener.entity.Url

interface UrlService {

    suspend fun saveUrl(url: Url): Url

    suspend fun getUrl(shortenedUrl: String): Url

}