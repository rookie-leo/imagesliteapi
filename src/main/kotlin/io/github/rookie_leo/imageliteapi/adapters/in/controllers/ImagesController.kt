package io.github.rookie_leo.imageliteapi.adapters.`in`.controllers

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/v1/images")
class ImagesController {

    private val log = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun save(
        @RequestParam("file") file: MultipartFile,
        @RequestParam("name") name: String,
        @RequestParam("tags") tags: List<String>
    ): ResponseEntity<Void> {
        log.info("Loaded image: ${file} - \nsize: ${file.size}" +
                "\nImage name: ${name}" +
                "\nTags: ${tags}")
        return ResponseEntity.ok().build()
    }

}