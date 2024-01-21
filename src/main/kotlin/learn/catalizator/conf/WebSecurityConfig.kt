package learn.catalizator.conf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.stereotype.Component

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@Configuration
class WebSecurityConfig {
	@Bean
	fun passwordEncoder() :PasswordEncoder{
		println("PasswordEncoder")
		return NoOpPasswordEncoder.getInstance()

	}

	@Bean
	fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
		println("securityWebFilterChain")
		return http
			.csrf { csrf ->
				csrf.disable()
			}
			.formLogin {}
			.httpBasic { httpBasic ->
				httpBasic.disable()
			}
			.authorizeExchange{
				auth->
				auth.pathMatchers("/","/login", "/favicom.ico").permitAll()
				auth.pathMatchers("/controller").hasRole("ADMIN")
				auth.anyExchange().authenticated()
			}
			.build()
	}
}