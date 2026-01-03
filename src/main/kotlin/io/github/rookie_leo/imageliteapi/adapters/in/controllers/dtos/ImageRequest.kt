package io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos

import org.springframework.web.multipart.MultipartFile

data class ImageRequest (
    val file: MultipartFile,
    val name: String,
    val tags: List<String>
)
