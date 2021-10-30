package com.lel.quote.dto

import com.lel.quote.utils.CategoryQuoteEnum
import java.time.LocalDate

class QuoteDTO(
    var quote: String = "",
    var author: String = "",
    var date: LocalDate?,
    var stars: Int = 0,
    var isTopRated: Boolean = false,
    var category: String? = null
) {
    @Transient
    private var categoryQuote: CategoryQuoteEnum? = null
        get() {
            val valueOf = CategoryQuoteEnum.valueOf(category!!.uppercase())
            category = valueOf.value
            return valueOf
        }
        set(value) {
            category = value?.toValue()
            field = value
        }
}
