package com.morrice256.demo.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.validation.annotation.Validated


@Validated
@Configuration
class JwtAuthConverterProperties {
    @Value("\${jwt.auth.converter.resource-id}")
    val resourceId: String? = null
    @Value("\${jwt.auth.converter.principal-attribute}")
    val principalAttribute: String? = null
}