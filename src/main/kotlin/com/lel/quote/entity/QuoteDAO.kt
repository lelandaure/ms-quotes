package com.lel.quote.entity

import com.lel.quote.utils.CategoryQuoteEnum
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document("quotes")
class QuoteDAO(
    @Id
    val id: Int,
    var quote: String = "",
    var author: String = "",
    var date: LocalDate? = null,
    var stars: Int = 0,
    var isTopRated: Boolean = false,
    var category: String? = null
) {
    @Transient
    var categoryQuote: CategoryQuoteEnum? = null
        get() {
            val valueOf = CategoryQuoteEnum.valueOf(category!!.uppercase())
            category = valueOf.value
            return valueOf
        }
        set(value) {
            category = value?.value
            field = value
        }
}