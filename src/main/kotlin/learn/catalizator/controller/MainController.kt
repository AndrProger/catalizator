package learn.catalizator.controller

import learn.catalizator.damain.Message
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import learn.catalizator.service.MessageService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/controller")
class MainController(
	private val messageService: MessageService
) {

	@GetMapping
	 fun list(
		 @RequestParam(defaultValue = "1") start: Long,
		 @RequestParam(defaultValue = "3") count: Long
	 ): Flux<Message> {
		return messageService.list()
	}

	@PostMapping
	fun addOne(
		@RequestBody message:Message
	):Mono<Message>{
		return messageService.addOne(message)
	}
}