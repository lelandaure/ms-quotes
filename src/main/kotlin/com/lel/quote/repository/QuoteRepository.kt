package com.lel.quote.repository

import com.lel.quote.entity.Quote
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface QuoteRepository
    : ReactiveMongoRepository<Quote, Int>