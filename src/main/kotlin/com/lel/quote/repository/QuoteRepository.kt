package com.lel.quote.repository

import com.lel.quote.entity.QuoteDAO
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface QuoteRepository
    : ReactiveMongoRepository<QuoteDAO, Int>