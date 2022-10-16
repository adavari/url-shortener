package com.adavari.shortener.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ShortenedUrlResponse(
    @JsonProperty("shortened_url") val shortenedUrl: String,
    @JsonProperty("original_url") val originalUrl: String
)