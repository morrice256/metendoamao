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

        Dado("I have {int} cakes in my belly") { int1: Int? ->
            // Write code here that turns the phrase above into concrete actions
        }
        Quando("I wait {int} hour") { int1: Int? ->
            // Write code here that turns the phrase above into concrete actions
        }
        Então("my belly should growl") {
            // Write code here that turns the phrase above into concrete actions
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