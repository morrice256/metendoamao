package com.morrice256.demo.config

import org.springframework.beans.factory.annotation.Autowired
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

    @Autowired
    lateinit var jwtAuthConverter: JwtAuthConverter

    @Bean
    protected fun sessionAuthenticationStrategy(): SessionAuthenticationStrategy? {
        return RegisterSessionAuthenticationStrategy(SessionRegistryImpl())
    }

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        http
                .authorizeHttpRequests { authz -> authz
                    .requestMatchers("/origemDestino/destino/**").permitAll()
                    .requestMatchers("/pessoa/juridica/**").hasAuthority("SCOPE_email")
                    .requestMatchers("/pessoa/fisica/**").hasAuthority("SCOPE_read")
                    .requestMatchers("/pessoa/**").hasRole("USER")
                    .anyRequest().authenticated()
        }

        http.oauth2ResourceServer { obj: OAuth2ResourceServerConfigurer<HttpSecurity?> ->
            obj.jwt {
                it.jwtAuthenticationConverter(jwtAuthConverter)
            }
        }
        return http.build()
    }

}