package com.adavari.shortener.service

interface SequenceService {

    suspend fun getSequenceNumber(): Long

}