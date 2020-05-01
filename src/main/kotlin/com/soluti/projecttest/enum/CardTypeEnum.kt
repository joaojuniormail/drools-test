package com.soluti.projecttest.enum

enum class CardTypeEnum(val type: String) {
    MASTERCARD("MasterCard"),
    VISA("Visa"),
    HIPERCARD("HiperCard"),
    AMERICANEXPRESS("AmericanExpress");

    override fun toString(): String {
        return this.type
    }
}