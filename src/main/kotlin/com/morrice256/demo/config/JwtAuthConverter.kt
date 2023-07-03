package com.morrice256.demo.config

import jakarta.servlet.Filter
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.convert.converter.Converter
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.jwt.JwtClaimNames
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter
import org.springframework.stereotype.Component
import java.util.stream.Collectors
import java.util.stream.Stream


@Component
class JwtAuthConverter: Converter<Jwt, AbstractAuthenticationToken> {

    @Value("\${jwt.auth.converter.resource-id}")
    val resourceId: String? = null
    @Value("\${jwt.auth.converter.principal-attribute}")
    val principalAttribute: String? = null

    private var jwtGrantedAuthoritiesConverter = JwtGrantedAuthoritiesConverter()

    override fun convert(jwt: Jwt): AbstractAuthenticationToken? {
        val authorities: Collection<GrantedAuthority> = Stream.concat(
                jwtGrantedAuthoritiesConverter.convert(jwt)!!.stream(),
                extractResourceRoles(jwt)!!.stream()).collect(Collectors.toSet())
        return JwtAuthenticationToken(jwt, authorities, getPrincipalClaimName(jwt))
    }

    private fun getPrincipalClaimName(jwt: Jwt): String? {
        var claimName = JwtClaimNames.SUB
        if (this.principalAttribute != null) {
            claimName = this.principalAttribute!!
        }
        return jwt.getClaim(claimName)
    }

    private fun extractResourceRoles(jwt: Jwt): Collection<GrantedAuthority>? {
        val resourceAccess = jwt.getClaim<Map<String, Any>>("resource_access")
        val resource: Map<String?, Any?> = resourceAccess.get(this.resourceId) as Map<String?, Any?>
        val resourceRoles: Collection<String> = resource.get("roles") as Collection<String>

        return resourceRoles.stream()
                .map{ role: String -> SimpleGrantedAuthority("ROLE_$role") }
                .collect(Collectors.toSet())
    }
}