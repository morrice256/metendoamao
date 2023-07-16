package com.morrice256.demo.controller

import api.UserApi
import model.UserDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController: UserApi{

    override fun findOne(id: Long): ResponseEntity<UserDto> {
        var dto = UserDto(id,
                "Morrice256",
                "morrice@gmail.com",
                "xpto")
        return ResponseEntity.ok(dto)
    }

    override fun save(userDto: UserDto): ResponseEntity<UserDto> {
        var dto = UserDto(1L,
                userDto.username,
                userDto.email,
                userDto.password)
        return ResponseEntity.ok(dto)
    }

}