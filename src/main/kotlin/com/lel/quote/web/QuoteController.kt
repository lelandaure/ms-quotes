package com.lel.quote.web

import com.lel.quote.dto.QuoteDTO
import com.lel.quote.service.QuoteService
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/quotes")
class QuoteController(
    @Autowired
    private val quoteService: QuoteService
) {
    @GetMapping
    fun getAllQuotes(): ResponseEntity<Flux<QuoteDTO>> {
        logger.info { "getting all quotes from controller" }
        return ResponseEntity.ok(quoteService.getAllQuotes())
    }
}