package com.morrice256.demo.bdd.cadastropessoafisica.steps

import io.cucumber.java8.PendingException
import io.cucumber.java8.Pt
import io.cucumber.java8.Scenario
import jakarta.inject.Inject

class CadastroPessoaFisicaSteps @Inject constructor() : Pt {

    init {
        configureSteps()
    }

    private fun configureSteps() {
        Before { scenario: Scenario ->  }

        After { scenario: Scenario ->  }

        Dado(
            "tenho não tenho o cpf {string} previamente cadastrado na base"
        ) { string: String? ->

        }
        Quando(
            "o cadastro de pessoa fisica for chamado com um o cpf {string} e data de nascimento {string}"
        ) { string: String?, string2: String? ->

        }
        Então("devo conseguir ter cadastrado uma nova pessoa fisica ativa e com a data de criação now") {

        }

    }
}