package learn.catalizator.controller

import learn.catalizator.damain.Message
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/controller")
class MainController {

	@GetMapping
	 fun list(
		 @RequestParam(defaultValue = "1") start: Long,
		 @RequestParam(defaultValue = "3") count: Long
	 ): Flux<Message> {
		return Flux.just(
			"Hello, reactive!",
			"More then one ",
			"Third post",
			"Fourth post",
			"Fifth post",
		)
			.skip(start)
			.take(count)
			.map { param -> Message(param) }
	}
}