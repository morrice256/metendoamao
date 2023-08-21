package com.morrice256.demo.bdd.steps

import io.cucumber.java8.PendingException
import io.cucumber.java8.Pt
import io.cucumber.java8.Scenario
import jakarta.inject.Inject
import org.slf4j.LoggerFactory

class ExampleSteps @Inject constructor() : Pt {

    private val log = LoggerFactory.getLogger(ExampleSteps::class.java)

    lateinit var testContext: TestContext;

    init {
        configureSteps()
    }

    private fun configureSteps() {
        Before { scenario: Scenario -> log.info("Before scenario : " + scenario.name) }

        After { scenario: Scenario -> log.info("After scenario : " + scenario.name) }

        Dado("que posso ter pre-requisitos no sistema e esses dados precisam existir na base ou em qualquer lugar") {

        }
        Quando("executar uma determinada tarefa ou chamar um serviço") {

        }
        Então("devo ter um resultados esperado para validar ou varios resultados para validar") {

        }


    }

}

class TestContext {
    private val context: ThreadLocal<MutableMap<String, Any>> = ThreadLocal.withInitial { mutableMapOf<String, Any>() }

    fun put(key: String, value: Any) {
        context.get()[key] = value
    }

    operator fun get(key: String): Any? {
        return context.get()[key]
    }

}