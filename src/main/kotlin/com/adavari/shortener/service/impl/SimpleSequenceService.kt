package com.adavari.shortener.service.impl

import com.adavari.shortener.exception.EmptyRangeException
import com.adavari.shortener.exception.InvalidRangeException
import com.adavari.shortener.service.CoordinationService
import com.adavari.shortener.service.SequenceService
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class SimpleSequenceService(private val coordinationService: CoordinationService) : SequenceService {

    private var currentRange: LongRange = LongRange.EMPTY
    private val counter = AtomicLong(0)

    override suspend fun getSequenceNumber(): Long {
        if (currentRange == LongRange.EMPTY) {
            currentRange = coordinationService.getSequenceRange()
        }
        if (currentRange == LongRange.EMPTY) {
            throw EmptyRangeException("given range is empty")
        }
        if (currentRange.first == currentRange.last) {
            throw InvalidRangeException("given range is invalid!")
        }
        if (counter.get() == currentRange.endInclusive) {
            currentRange = coordinationService.getSequenceRange()
        }

        return counter.incrementAndGet()
    }

}