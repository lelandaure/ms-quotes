package com.lel.quote.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("quotes")
data class Quote(
    @Id
    val id: String = "",
    val quote: String = "",
    val author: String = ""
)