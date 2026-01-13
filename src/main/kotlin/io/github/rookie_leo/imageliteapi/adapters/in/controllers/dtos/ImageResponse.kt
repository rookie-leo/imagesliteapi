package io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import io.github.rookie_leo.imageliteapi.core.domain.ImageExtension
import java.net.URI
import java.time.LocalDate

data class ImageResponse (
    val id: String,
    val name: String,
    val size: Long,
    val extension: ImageExtension,
    @JsonFormat(pattern = "dd/MM/yyyy")
    val uploadDate: LocalDate,
    val tags: String,
    @JsonIgnore
    val file: ByteArray,
    var imageUri: URI? = null
)
