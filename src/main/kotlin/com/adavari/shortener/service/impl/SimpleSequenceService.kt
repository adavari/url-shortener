package com.adavari.shortener.service.impl

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
        if (counter.get() == currentRange.endInclusive) {
            currentRange = coordinationService.getSequenceRange()
        }

        return counter.incrementAndGet();
    }

}