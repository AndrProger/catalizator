package learn.catalizator.damain

import org.springframework.data.annotation.Id

data class Message (
	@Id
	val id: Long? = null,
	val data: String?=null
)