package com.morrice256.demo.domain.pessoa

import jakarta.persistence.*

@Entity
@Table(name ="pj")
class PessoaJuridica (
        @Id @GeneratedValue
        var id: Long? = null,
        @Column
        var cnpj: String,
        @Column
        var ie: String,
        @Column
        var dataAbertura: String,
        @Column
        var ativa: Boolean,
        @Column
        var createdOn: String
)