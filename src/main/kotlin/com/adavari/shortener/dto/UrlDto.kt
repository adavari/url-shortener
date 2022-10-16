package com.adavari.shortener.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.URL

data class UrlDto(
    @JsonProperty("url") @URL(message = "Given url is not valid!") val url: String
)
