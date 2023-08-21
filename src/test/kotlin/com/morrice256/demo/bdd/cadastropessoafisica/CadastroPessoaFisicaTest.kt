package com.morrice256.demo.bdd.cadastropessoafisica

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(features = ["classpath:features/CadastroPessoaFisica.feature"],
    tags = "not @Wip", glue = ["classpath:com.morrice256.demo.bdd.cadastropessoafisica.steps", ""], plugin = ["pretty", "html:target/cucumber/html"])
class CadastroPessoaFisicaTest