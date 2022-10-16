package com.adavari.shortener.service.impl

import com.adavari.shortener.exception.EmptyRangeException
import com.adavari.shortener.exception.InvalidRangeException
import com.adavari.shortener.service.CoordinationService
import com.adavari.shortener.service.SequenceService
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SimpleSequenceServiceTest {

    @Test
    fun given_EmptyRange_when_getSequenceNumber_then_throwEmptyRangeException() = runTest {
        val coordinationService: CoordinationService = object : CoordinationService {
            override suspend fun getSequenceRange(): LongRange {
                return LongRange.EMPTY
            }
        }

        val sequenceService: SequenceService = SimpleSequenceService(coordinationService)

        assertThrows<EmptyRangeException> {
            sequenceService.getSequenceNumber()
        }
    }

    @Test
    fun given_RangeWithSameStartAndEnd_when_getSequenceNumber_then_throwInvalidRangeException() = runTest {
        val coordinationService: CoordinationService = object : CoordinationService {
            override suspend fun getSequenceRange(): LongRange {
                return LongRange(1, 1)
            }
        }

        val sequenceService: SequenceService = SimpleSequenceService(coordinationService)

        assertThrows<InvalidRangeException> {
            sequenceService.getSequenceNumber()
        }

    }

    @Test
    fun given_Range_when_getSequenceNumber_then_shouldReturnCorrectSequence() = runTest {
        val coordinationService: CoordinationService = object : CoordinationService {
            override suspend fun getSequenceRange(): LongRange {
                return LongRange(1, 10)
            }
        }

        val sequenceService: SequenceService = SimpleSequenceService(coordinationService)

        assertEquals(1, sequenceService.getSequenceNumber())
    }



}