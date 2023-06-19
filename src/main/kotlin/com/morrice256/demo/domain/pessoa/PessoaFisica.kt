package com.morrice256.demo.domain.pessoa

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name ="pf")
class PessoaFisica (
    @Id
    @GeneratedValue
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