package io.github.rookie_leo.imageliteapi.adapters.`in`.controllers

import io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos.ImageRequest
import io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos.ImageResponse
import io.github.rookie_leo.imageliteapi.adapters.service.ImageService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/v1/images")
class ImagesController(
    val service: ImageService
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun save(
        @RequestParam("file") file: MultipartFile,
        @RequestParam("name") name: String,
        @RequestParam("tags") tags: List<String>
    ): ResponseEntity<ImageResponse> {
        log.info("Loaded image: ${file} - \nsize: ${file.size}" +
                "\nImage name: ${name}" +
                "\nTags: ${tags}")
        return ResponseEntity.ok().body(service.save(ImageRequest(
            name = name,
            tags = tags,
            file = file
        )))
    }

}