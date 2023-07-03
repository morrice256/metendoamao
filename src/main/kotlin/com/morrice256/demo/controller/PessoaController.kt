package com.morrice256.demo.controller

import com.morrice256.demo.domain.pessoa.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pessoa")
class PessoaController (private val pessoaFisicaRepository: PessoaFisicaRepository,
                        private val pessoaJuridicaRepository: PessoaJuridicaRepository){

    @GetMapping
    fun listPessoa(@RequestParam(required = false, defaultValue = "") tipoDocumento: String,
                   @RequestParam(required = false, defaultValue = "") numeroDocumento: String,
                   pageable: Pageable): Page<Pessoa> {
        return pessoaFisicaRepository.listarPFePJ(tipoDocumento, numeroDocumento, pageable)
    }

    @GetMapping("/fisica")
    fun listFisica(): MutableIterable<PessoaFisica> {
        return pessoaFisicaRepository.findAll()
    }

    @GetMapping("/juridica")
    fun listJuridica(): MutableIterable<PessoaJuridica> {
        return pessoaJuridicaRepository.findAll()
    }
}