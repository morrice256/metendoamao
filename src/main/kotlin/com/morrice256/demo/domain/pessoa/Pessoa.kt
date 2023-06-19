package com.morrice256.demo.domain.pessoa

interface Pessoa {
    var id: Long?
    var numeroDocumento: String
    var data: String
    var ativa: Boolean
    var createdOn: String
    var tipoDocumento: String
}