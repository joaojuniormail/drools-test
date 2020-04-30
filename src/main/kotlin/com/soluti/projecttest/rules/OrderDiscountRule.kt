package com.soluti.projecttest.rules

import com.soluti.projecttest.model.Order
import org.drools.core.impl.KnowledgeBaseFactory
import org.kie.api.KieServices
import org.kie.api.runtime.KieContainer


class OrderDiscountRule(var order: Order) {

    init {
        val kc = KieServices.Factory.get().kieClasspathContainer
        execute(kc)
    }

    fun execute(kc: KieContainer) {
        val ksession = kc.newKieSession("OrderDiscount")
        ksession.insert(order)
        ksession.fireAllRules()
        ksession.dispose() // Stateful rule session must always be disposed when finished
    }
}