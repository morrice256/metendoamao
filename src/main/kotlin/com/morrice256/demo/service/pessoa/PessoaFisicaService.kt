package com.morrice256.demo.service.pessoa

import com.morrice256.demo.domain.pessoa.Pessoa
import com.morrice256.demo.domain.pessoa.PessoaFisica
import com.morrice256.demo.domain.pessoa.PessoaFisicaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PessoaFisicaService (private val pessoaFisicaRepository: PessoaFisicaRepository){


    fun listarPFePJ(tipoDocumento: String,
                    numeroDocumento: String,
                    pageable: Pageable
    ): Page<Pessoa>{
        return return pessoaFisicaRepository.listarPFePJ(tipoDocumento, numeroDocumento, pageable)
    }

    fun findAll(): MutableIterable<PessoaFisica> {
        return pessoaFisicaRepository.findAll()
    }


}