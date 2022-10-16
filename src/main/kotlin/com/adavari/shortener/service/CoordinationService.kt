package com.adavari.shortener.service

interface CoordinationService {

    suspend fun getSequenceRange(): LongRange

}