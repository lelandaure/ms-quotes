package com.lel.quote.entity

import com.lel.quote.utils.CategoryQuoteEnum
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document("quotes")
class QuoteDAO(
    @Id
    val id: String = "",
    var quote: String = "",
    var author: String = "",
    var date: LocalDate? = null,
    var stars: Int = 0,
    var isTopRated: Boolean = false,

    private var category: String? = null
) {
    @Transient
    var categoryQuote: CategoryQuoteEnum? = null
        get() {
            return CategoryQuoteEnum.valueOf(category!!.uppercase())
        }
        set(value) {
            category = value?.toValue()
            field = value
        }

    /*
    fun category(): CategoryQuoteEnum {
        return CategoryQuoteEnum.fromValue(category)
    }

    fun setCategory(cate: CategoryQuoteEnum) {
        this.category = cate.toValue()
    }*/
}