package com.morrice256.demo.service

import com.morrice256.demo.domain.pessoa.PessoaFisica
import com.morrice256.demo.domain.pessoa.PessoaFisicaRepository
import com.morrice256.demo.base.ServiceBase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Objects

@Service
class PessoaFisicaService : ServiceBase<PessoaFisica>() {

    @Autowired
    lateinit var repository: PessoaFisicaRepository
    override fun update(entity: PessoaFisica, id: Long): PessoaFisica {
        var entityOld: PessoaFisica = repository.findFistByCpf(entity.cpf)
        entity.createdOn = entityOld.createdOn
        return super.update(entity, id)
    }

    override fun validateUpdate(entity: PessoaFisica) {
        var entityOld: PessoaFisica = repository.findFistByCpf(entity.cpf)
        if(Objects.nonNull(entityOld) && entityOld.id != entity.id){
            throw Exception("CPF já cadastrado")
        }
    }
}