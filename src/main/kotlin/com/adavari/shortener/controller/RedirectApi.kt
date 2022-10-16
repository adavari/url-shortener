package com.adavari.shortener.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import javax.servlet.http.HttpServletResponse

@RequestMapping("/")
interface RedirectApi {

    @GetMapping("{url}")
    @ResponseStatus(HttpStatus.FOUND)
    suspend fun redirectUrl(@PathVariable("url") url: String, servletResponse: HttpServletResponse)

}