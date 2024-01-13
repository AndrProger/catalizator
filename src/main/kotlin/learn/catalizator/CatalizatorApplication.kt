package learn.catalizator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CatalizatorApplication

fun main(args: Array<String>) {
	runApplication<CatalizatorApplication>(*args)
}
