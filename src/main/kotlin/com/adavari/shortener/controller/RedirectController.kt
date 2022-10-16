package com.adavari.shortener.controller

import com.adavari.shortener.service.UrlService
import org.springframework.stereotype.Controller
import javax.servlet.http.HttpServletResponse

@Controller
class RedirectController(private val urlService: UrlService) : RedirectApi {

    override suspend fun redirectUrl(url: String, servletResponse: HttpServletResponse) {
        val originalUrl = urlService.getUrl(url)
        servletResponse.setHeader("Location", originalUrl.url)
        servletResponse.status = 302
    }
}