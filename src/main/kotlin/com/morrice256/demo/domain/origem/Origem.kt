package com.morrice256.demo.domain.origem

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Origem (
    @Id @GeneratedValue
    var id: Long? = null,
    @Column
    var name: String,
    @Column
    var cidade: String,
    @Column
    var estado: String)

