package com.morrice256.demo.controller

import com.morrice256.demo.domain.*
import com.morrice256.demo.domain.origem.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/origemDestino")
class OrigemDestinoController(private val origemRepository: OrigemRepository,
                              private val destinoRepository: DestinoRepository) {

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