package io.github.rookie_leo.imageliteapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class ImageliteapiApplication

fun main(args: Array<String>) {
	runApplication<ImageliteapiApplication>(*args)
}
