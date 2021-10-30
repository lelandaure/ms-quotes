package com.lel.quote.utils


enum class CategoryQuoteEnum(val value: String) {
    LIFE("life"),
    SPORTS("sports"),
    RELIGION("religion"),
    CODE("code"),
    OTHER("other");

    fun toValue(): String {
        return value
    }

    companion object {
        fun fromValue(value: String?): CategoryQuoteEnum {
            if (value != null) {
                for (each in values()) {
                    if (each.value == value) {
                        return each
                    }
                }
            }

            // you may return a default value
            return OTHER
            // or throw an exception
            // throw new IllegalArgumentException("Invalid color: " + value);
        }
    }
}