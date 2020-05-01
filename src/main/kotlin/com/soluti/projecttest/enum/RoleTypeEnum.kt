package com.soluti.projecttest.enum

enum class RoleTypeEnum(val fileName: String) {
    ORDERDISCOUNT("OrderDiscountRule");

    override fun toString(): String {
        return this.fileName
    }
}