package com.lel.quote.service

import com.lel.quote.dto.QuoteDTO
import com.lel.quote.repository.QuoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class QuoteServiceImpl(
    @Autowired private val quoteRepository: QuoteRepository
) : QuoteService {

    override fun getAllQuotes(): Flux<QuoteDTO> {
        return quoteRepository.findAll().map {
            QuoteDTO(it.quote, it.author)
        }
    }
}