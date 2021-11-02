package com.lel.quote.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "db_sequence")
class DbSequence(
    @Id
    var id: String,
    var seq: Int
) {

    companion object {
        @Transient
        const val SEQUENCE_NAME = "user"
    }
}