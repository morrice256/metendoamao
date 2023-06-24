package com.morrice256.demo.controller

import com.morrice256.demo.domain.*
import com.morrice256.demo.domain.origem.*
import com.morrice256.demo.domain.origem.dto.HomeDto
import com.morrice256.demo.domain.origem.dto.OrigemDto
import com.morrice256.demo.domain.origem.mapper.OrigemMapper
import com.morrice256.demo.domain.pessoa.PessoaFisica
import com.morrice256.demo.domain.pessoa.PessoaFisicaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/origemDestino")
class OrigemDestinoController(private val origemRepository: OrigemRepository,
                              private val destinoRepository: DestinoRepository,
                              private val pessoaFisicaRepository: PessoaFisicaRepository,
                              private var origemMapper: OrigemMapper) {

    @GetMapping("/origem/{id}/home/document")
    fun getHomeDocument(@PathVariable id: Long): HomeDto? {
        val origem = origemRepository.findById(id)
        val pessoa = pessoaFisicaRepository.findById(id)
        return origemMapper.entityToHomeDtoWithPerson(origem.get(), pessoa.get())
    }
    @GetMapping("/origem/{id}/home")
    fun getHome(@PathVariable id: Long): HomeDto? {
        var entity = origemRepository.findById(id)
        return origemMapper.entityToHomeDto(entity.get())
    }

    @GetMapping("/origem/{id}")
    fun getOrigem(@PathVariable id: Long): OrigemDto? {
        var entity = origemRepository.findById(id)
        return origemMapper.entityToDto(entity.get())
    }

    @GetMapping
    fun listOrigemDestino(pageable: Pageable): Page<OrigemDestino> {
        return origemRepository.listOrigemAndDestino(pageable)
    }

    @GetMapping("/origem")
    fun listOrigem(): MutableIterable<Origem> {
        return origemRepository.findAll()
    }

    @GetMapping("/destino")
    fun listDestino(): MutableIterable<Destino> {
        return destinoRepository.findAll()
    }

}