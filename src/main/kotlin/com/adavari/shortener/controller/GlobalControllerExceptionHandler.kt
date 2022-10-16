package com.adavari.shortener.controller

import com.adavari.shortener.dto.MessageResponse
import com.adavari.shortener.exception.EmptyRangeException
import com.adavari.shortener.exception.InvalidRangeException
import com.adavari.shortener.exception.UrlNotFoundException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalControllerExceptionHandler {

    @Autowired private lateinit var mapper: ObjectMapper

    @ExceptionHandler(EmptyRangeException::class)
    fun handleEmptyRange(emptyRangeException: EmptyRangeException): ResponseEntity<String> {
        val response = MessageResponse(true, "internal server error")
        return ResponseEntity(mapper.writeValueAsString(response), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(InvalidRangeException::class)
    fun handleInvalidRange(invalidRangeException: InvalidRangeException): ResponseEntity<String> {
        val response = MessageResponse(true, "internal server error")
        return ResponseEntity(mapper.writeValueAsString(response), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(UrlNotFoundException::class)
    fun handleUrlNotFound(urlNotFoundException: UrlNotFoundException): ResponseEntity<String> {
        val response = MessageResponse(false, "path not found")
        return ResponseEntity(mapper.writeValueAsString(response), HttpStatus.NOT_FOUND)
    }

}