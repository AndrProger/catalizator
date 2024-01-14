package learn.catalizator.repo

import learn.catalizator.damain.Message
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepo:ReactiveCrudRepository<Message,Long> {
}