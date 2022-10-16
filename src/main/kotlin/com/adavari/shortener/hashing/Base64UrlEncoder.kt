package com.adavari.shortener.hashing

import java.util.*

class Base64UrlEncoder(private val input: ByteArray) {

    override fun toString(): String = Base64
        .getUrlEncoder().encodeToString(input)

}