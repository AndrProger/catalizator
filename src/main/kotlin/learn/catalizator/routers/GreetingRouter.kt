package learn.catalizator.routers

import learn.catalizator.handlers.GreetingHandler
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.BodyInserter
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse

import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.accept

@Configuration(proxyBeanMethods = false)
class GreetingRouter {
	@Bean
	fun route(greetingHandler: GreetingHandler): RouterFunction<ServerResponse> {
		val rout = GET("/hello")
			.and(accept(MediaType.APPLICATION_JSON))
		return RouterFunctions
			.route(
				rout,
				greetingHandler::hello
			)
			.andRoute(
				GET("/"),
				greetingHandler::index
			)
	}
}