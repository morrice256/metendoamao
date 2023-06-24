package com.morrice256.demo.domain.origem.mapper

import com.morrice256.demo.domain.origem.Origem
import com.morrice256.demo.domain.origem.dto.HomeDto
import com.morrice256.demo.domain.origem.dto.OrigemDto
import com.morrice256.demo.domain.pessoa.PessoaFisica
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Named

@Mapper(componentModel = "spring")
interface OrigemMapper {

    fun entityToDto(entity: Origem): OrigemDto

    @Mapping(source = "id", target = "identifier")
    @Mapping(source = "cidade", target = "city")
    @Mapping(source = "estado", target = "state")
    fun entityToHomeDto(entity: Origem): HomeDto

    @Mapping(source = "origem.id", target = "identifier")
    @Mapping(source = "origem.cidade", target = "city")
    @Mapping(source = "origem.estado", target = "state")
    @Mapping(source = "pessoa.cpf", target = "accountableDocument", qualifiedByName = ["maskDocument"])
    fun entityToHomeDtoWithPerson(origem: Origem, pessoa: PessoaFisica): HomeDto

    companion object {
        @JvmStatic
        @Named("maskDocument")
        fun maskDocument(document: String): String {
            var doc = ""
            var last = document.chunked(3).size
            var delimite = "."
            document.chunked(3).forEach {
                last--
                if(last == 1) delimite = "-"
                if(last == 0) delimite = ""
                doc += it+delimite
            }
            return doc
        }
    }
}