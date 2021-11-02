package com.lel.quote.service

import com.lel.quote.dto.QuoteDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface QuoteService {
    fun getAllQuotes(): Flux<QuoteDTO>
    fun saveQuote(quoteDTO: QuoteDTO): Mono<QuoteDTO>
}