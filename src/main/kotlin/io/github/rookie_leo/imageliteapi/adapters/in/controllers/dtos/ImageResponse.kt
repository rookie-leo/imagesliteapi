package io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos

import io.github.rookie_leo.imageliteapi.core.domain.ImageExtension
import java.time.LocalDateTime

data class ImageResponse (
    val id: String,
    val name: String,
    val size: Long,
    val extension: ImageExtension,
    val uploadDate: LocalDateTime,
    val tags: String,
    val file: ByteArray
)
