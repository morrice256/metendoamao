package com.morrice256.demo.domain.pessoa

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name ="pf")
class PessoaFisica (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pf_generator")
    @SequenceGenerator(name = "pf_generator", sequenceName = "pf_SEQ", allocationSize = 1)
    var id: Long? = null,
    @Column
    var cpf: String,
    @Column
    var dataNascimento: String,
    @Column
    var ativa: Boolean,
    @Column
    var createdOn: String
)