package com.lel.quote.service

import com.lel.quote.dto.QuoteDTO
import com.lel.quote.entity.DbSequence
import com.lel.quote.entity.DbSequence.Companion.SEQUENCE_NAME
import com.lel.quote.entity.QuoteDAO
import com.lel.quote.repository.QuoteRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

//private val logger = KotlinLogging.logger {}

@Service
class QuoteServiceImpl(
    @Autowired
    private val quoteRepository: QuoteRepository,
    @Autowired
    private val reactiveMongoOperations: ReactiveMongoOperations
) : QuoteService {

    override fun getAllQuotes(): Flux<QuoteDTO> =
        quoteRepository.findAll().map(this::toDTO)

    override fun saveQuote(quoteDTO: QuoteDTO): Mono<QuoteDTO> =
        sequenceNumber().flatMap {
            quoteRepository.save(this.toDAO(it.seq,quoteDTO))
        }.map(this::toDTO)

    private fun sequenceNumber() = reactiveMongoOperations.findAndModify(
        Query(Criteria.where("id").`is`(SEQUENCE_NAME)),
        Update().inc("seq", 1),
        FindAndModifyOptions.options().returnNew(true).upsert(true),
        DbSequence::class.java
    )

    private fun toDTO(quoteDAO: QuoteDAO): QuoteDTO =
        QuoteDTO(
            quoteDAO.id,
            quoteDAO.quote,
            quoteDAO.author,
            quoteDAO.date,
            quoteDAO.stars,
            quoteDAO.isTopRated,
            quoteDAO.categoryQuote?.value
        )

    private fun toDAO(id: Int, quoteDTO: QuoteDTO): QuoteDAO =
        QuoteDAO(
            id,
            quoteDTO.quote,
            quoteDTO.author,
            quoteDTO.date,
            quoteDTO.stars,
            quoteDTO.isTopRated,
            quoteDTO.categoryQuote?.value
        )

}