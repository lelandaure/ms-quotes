package com.lel.quote.service

import com.lel.quote.dto.QuoteDTO
import com.lel.quote.repository.QuoteRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

private val logger = KotlinLogging.logger {}

@Service
class QuoteServiceImpl(
    @Autowired
    private val quoteRepository: QuoteRepository
) : QuoteService {

    override fun getAllQuotes(): Flux<QuoteDTO> {
//        logger.info { quoteRepository.findAll().blockFirst() }
        return quoteRepository.findAll().map { quoteDAO ->
            logger.info { quoteDAO }
            val category = quoteDAO.categoryQuote?.value
            QuoteDTO(
                quoteDAO.quote,
                quoteDAO.author,
                quoteDAO.date,
                quoteDAO.stars,
                quoteDAO.isTopRated,
                category
            )
        }
    }
}