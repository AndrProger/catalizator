package learn.catalizator.service

import learn.catalizator.repo.UserRepo
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserService(
	private val userRepo: UserRepo
) :ReactiveUserDetailsService{
	override fun findByUsername(username: String?): Mono<UserDetails> {
		return userRepo.findByUsername(username!!)!!.cast(UserDetails::class.java)
	}

}