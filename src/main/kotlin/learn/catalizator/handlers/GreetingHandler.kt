package learn.catalizator.handlers

import learn.catalizator.damain.Message
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class GreetingHandler {
	fun hello(request: ServerRequest): Mono<ServerResponse> {
		val start = request.queryParam("start").map(String::toLong).orElse(1)
		val count = request.queryParam("count").map(String::toLong).orElse(3)

		val date = Flux.just(
			"Hello, reactive!",
			"More then one ",
			"Third post",
			"Fourth post",
			"Fifth post",
		)
			.skip(start)
			.take(count)
			.map { param -> Message(param) }


		return ServerResponse
			.ok()
			.contentType(MediaType.APPLICATION_JSON)
			.body(date, Message::class.java)
	}

	fun index(request: ServerRequest): Mono<ServerResponse> {
		val user = request.queryParams()["user"]?.first() ?: "Nobody"

		return ServerResponse
			.ok()
			.render(
				"index",
				mapOf("user" to user)
			)
	}
}