package com.adavari.shortener.hashing

import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8

class MD5(private val url: String) {

    fun toBytes(): ByteArray = MessageDigest.getInstance("MD5")
            .digest(url.toByteArray(UTF_8))

}