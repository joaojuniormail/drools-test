package com.soluti.projecttest.controller

import com.soluti.projecttest.model.Order
import com.soluti.projecttest.rules.OrderDiscountRule
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class MegaOfferController {

    @PostMapping("/order")
    fun orderNow(@RequestBody order: Order): Order {
        OrderDiscountRule(order)
        return order
    }
}