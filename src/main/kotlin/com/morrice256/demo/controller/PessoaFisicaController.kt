package com.morrice256.demo.controller

import com.morrice256.demo.domain.pessoa.PessoaFisica
import com.morrice256.demo.service.PessoaFisicaService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pessoa-fisica")
class PessoaFisicaController(val service: PessoaFisicaService) {

    @PostMapping
    fun save(@RequestBody pessoafisica: PessoaFisica): PessoaFisica {
        return service.create(pessoafisica)
    }

    @PutMapping("/{id}")
    fun update(@RequestBody pessoafisica: PessoaFisica, @PathVariable id: Long): PessoaFisica {
        return service.update(pessoafisica, id)
    }
}