package com.morrice256.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer
import org.springframework.security.core.session.SessionRegistryImpl
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy


@Configuration
@EnableWebSecurity
class SecurityConfig {

    private var keycloakLogoutHandler: KeycloakLogoutHandler? = null

    fun SecurityConfig(keycloakLogoutHandler: KeycloakLogoutHandler?) {
        this.keycloakLogoutHandler = keycloakLogoutHandler
    }

    @Bean
    protected fun sessionAuthenticationStrategy(): SessionAuthenticationStrategy? {
        return RegisterSessionAuthenticationStrategy(SessionRegistryImpl())
    }

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        http.authorizeHttpRequests { authz -> authz
                    .requestMatchers("/origemDestino/destino/**").permitAll()
                    .anyRequest().authenticated()
        }

        http.oauth2ResourceServer { obj: OAuth2ResourceServerConfigurer<HttpSecurity?> ->
            obj.jwt()
        }
        return http.build()

    }
}