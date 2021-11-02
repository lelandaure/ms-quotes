package com.lel.quote.dto

import com.lel.quote.utils.CategoryQuoteEnum
import java.time.LocalDate

class QuoteDTO(
    val id: Int = -1,
    var quote: String = "",
    var author: String = "",
    var date: LocalDate?,
    var stars: Int = 0,
    var isTopRated: Boolean = false,
    var category: String? = null
) {
    init {
        try {
            CategoryQuoteEnum.valueOf(category!!.uppercase())
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("the quote category is not permitted. $e")
        }

    }

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
