package com.morrice256.demo.domain.pessoa

import com.morrice256.demo.base.EntityBase
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name ="pf")
class PessoaFisica(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pf_seq")
    @SequenceGenerator(name = "pf_seq", sequenceName= "pf_seq", allocationSize = 1)
    override var id: Long? = null,
    @Column
    var cpf: String,
    @Column
    var dataNascimento: String,
    @Column
    var ativa: Boolean,
    @Column
    var createdOn: String
):  EntityBase()