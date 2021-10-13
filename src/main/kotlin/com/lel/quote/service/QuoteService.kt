package com.lel.quote.service

import com.lel.quote.dto.QuoteDTO
import reactor.core.publisher.Flux

interface QuoteService {
    fun getAllQuotes(): Flux<QuoteDTO>
}