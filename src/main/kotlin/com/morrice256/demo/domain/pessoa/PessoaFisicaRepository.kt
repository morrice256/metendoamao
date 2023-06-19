package com.morrice256.demo.domain.pessoa

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface PessoaFisicaRepository: CrudRepository<PessoaFisica, Long> {


    @Query(value ="""
            SELECT pessoa.id, pessoa.numero_documento as numeroDocumento, pessoa.data, pessoa.ativa,
            pessoa.created_on as createdOn, pessoa.tipo_documento as tipoDocumento FROM 
                (SELECT pf.id, pf.cpf as numero_documento, pf.data_nascimento as data, pf.ativa,
                pf.created_on, 'CPF' as tipo_documento
                FROM pf
                    UNION
                SELECT pj.id, pj.cnpj as numero_documento, pj.data_abertura as data, pj.ativa,
                pj.created_on, 'CNPJ' as tipo_documento
                FROM pj) pessoa
            WHERE pessoa.tipo_documento like %:tipoDocumento% 
            AND pessoa.numero_documento like %:numeroDocumento%
        """,
            countQuery = """
             SELECT count(*) FROM 
                (SELECT pf.id, pf.cpf as numero_documento, pf.data_nascimento as data, pf.ativa,
                pf.created_on, 'CPF' as tipo_documento
                FROM pf
                    UNION
                SELECT pj.id, pj.cnpj as numero_documento, pj.data_abertura as data, pj.ativa,
                pj.created_on, 'CNPJ' as tipo_documento
                FROM pj) pessoa
            WHERE pessoa.tipo_documento like %:tipoDocumento% 
            AND pessoa.numero_documento like %:numeroDocumento%
            """, nativeQuery = true)
    fun listarPFePJ(tipoDocumento: String,
                    numeroDocumento: String,
                    pageable: Pageable): Page<Pessoa>

}