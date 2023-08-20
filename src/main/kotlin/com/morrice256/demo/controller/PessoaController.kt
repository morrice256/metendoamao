package com.morrice256.demo.controller

import com.morrice256.demo.domain.pessoa.*
import com.morrice256.demo.service.pessoa.PessoaFisicaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pessoa")
class PessoaController (private val pessoaFisicaService: PessoaFisicaService,
                        private val pessoaJuridicaRepository: PessoaJuridicaRepository){

    @GetMapping
    fun listPessoa(@RequestParam(required = false, defaultValue = "") tipoDocumento: String,
                   @RequestParam(required = false, defaultValue = "") numeroDocumento: String,
                   pageable: Pageable): Page<Pessoa> {
        return pessoaFisicaService.listarPFePJ(tipoDocumento, numeroDocumento, pageable)
    }

    @GetMapping("/fisica")
    fun listFisica(): MutableIterable<PessoaFisica> {
        return pessoaFisicaService.findAll()
    }

    @GetMapping("/juridica")
    fun listJuridica(): MutableIterable<PessoaJuridica> {
        return pessoaJuridicaRepository.findAll()
    }
}