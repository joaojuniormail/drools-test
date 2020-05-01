package com.soluti.projecttest.rules

import com.soluti.projecttest.enum.RoleTypeEnum
import org.drools.core.impl.KnowledgeBaseFactory
import org.kie.api.io.ResourceType
import org.kie.api.runtime.KieSession
import org.kie.internal.builder.KnowledgeBuilderFactory
import org.kie.internal.io.ResourceFactory


class RuleRunner<T> (rule: RoleTypeEnum) {
    private var ksession: KieSession
    init {
        val kbase = KnowledgeBaseFactory.newKnowledgeBase()
        val kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder()
        val ruleFile = rule.fileName + ".drl"
        kbuilder.add(ResourceFactory.newClassPathResource(ruleFile,
                RuleRunner::class.java),
                ResourceType.DRL)
        val pkgs = kbuilder.knowledgePackages
        kbase.addPackages(pkgs)
        this.ksession = kbase.newKieSession()
    }

    fun execute(fact: T){
        this.ksession.insert(fact)
        this.ksession.fireAllRules()
    }

    fun destroy (){
       this.ksession.dispose()
    }
}