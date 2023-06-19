package com.morrice256.demo.domain.origem

import com.morrice256.demo.domain.origem.enums.TypeOD

interface OrigemDestino {
    var id: Long?
    var name: String
    var cidade: String
    var estado: String
    var type: TypeOD
}

