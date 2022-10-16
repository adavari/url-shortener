package com.adavari.shortener.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class EmptyRangeException(message: String) : RuntimeException(message)