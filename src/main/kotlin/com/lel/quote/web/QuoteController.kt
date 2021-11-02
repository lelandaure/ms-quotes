package com.lel.quote.web

import com.lel.quote.dto.QuoteDTO
import com.lel.quote.service.QuoteService
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/quotes")
class QuoteController(
    @Autowired
    private val quoteService: QuoteService,
) {
    @GetMapping
    fun getAllQuotes(): ResponseEntity<Flux<QuoteDTO>> {
        logger.info { "getting all quotes from controller" }
        return ResponseEntity.ok(quoteService.getAllQuotes())
    }

    @PostMapping
    fun saveQuote(@RequestBody monoQuoteDTO: QuoteDTO): ResponseEntity<Mono<QuoteDTO>> {
        logger.info { "creating a new Quote from Controller" }
        return ResponseEntity.ok(quoteService.saveQuote(monoQuoteDTO))
    }
}