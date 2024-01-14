package learn.catalizator.service

import learn.catalizator.damain.Message
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import learn.catalizator.repo.MessageRepo

@Service
class MessageService(
	private  val messageRepo: MessageRepo
) {

	 fun list(): Flux<Message> {
		return messageRepo.findAll()
	}

	fun addOne(message:Message): Mono<Message>{
		return  messageRepo.save(message);
	}
}