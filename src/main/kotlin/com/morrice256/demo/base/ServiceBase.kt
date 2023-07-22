package com.morrice256.demo.base

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
abstract class ServiceBase<T: EntityBase> {

    @Autowired
    lateinit var baseRepository: CrudRepository<T, Long>
    open fun create(entity: T): T{
        entity.id = null
        validate(entity)
        return this.save(entity)
    }

    open fun update(entity: T, id: Long): T{
        var entityOld = baseRepository.findById(id)
        if(entityOld.isEmpty){
            throw Exception("Registro não encontrado")
        }
        entity.id = id
        validateUpdate(entity)
        return this.save(entity)
    }

    private fun save(entity: T): T{
        validateSave(entity)
        return baseRepository.save(entity)
    }

    open fun validate(entity: T){

    }

    open fun validateSave(entity: T){

    }

    open fun validateUpdate(entity: T){

    }

}