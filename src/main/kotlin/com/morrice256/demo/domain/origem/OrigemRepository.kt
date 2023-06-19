package com.morrice256.demo.domain.origem

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface OrigemRepository: CrudRepository<Origem, Long>{

    @Query(value ="""
            SELECT od.id, od.name, od.cidade, od.estado, od.type FROM (
                SELECT o.id, o.name, o.cidade, o.estado, 'ORIGEM' as type FROM origem o
                union 
                SELECT d.id, d.name, d.cidade, d.estado, 'DESTINO' as type FROM destino d
            ) od
    """,
            countQuery ="""
            SELECT count(*) FROM (
                SELECT o.id, o.name, o.cidade, o.estado, 'ORIGEM' as type FROM origem o
                union 
                SELECT d.id, d.name, d.cidade, d.estado, 'DESTINO' as type FROM destino d
            ) od
    """, nativeQuery = true)
    fun listOrigemAndDestino(pageable: Pageable): Page<OrigemDestino>

}