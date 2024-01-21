package learn.catalizator.repo

import learn.catalizator.damain.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface UserRepo : ReactiveCrudRepository<User, Long> {
	fun findByUsername(username: String): Mono<User>?
}