package com.soluti.projecttest.model

import com.soluti.projecttest.enum.CardTypeEnum

class Order {

    lateinit var name: String
    lateinit var cardType: String
    var discount: Int = 0
    var price: Double = 0.0

}