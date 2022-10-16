package com.adavari.shortener.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class MessageResponse(
    @JsonProperty("error") val error: Boolean,
    @JsonProperty("message") val message: String
)