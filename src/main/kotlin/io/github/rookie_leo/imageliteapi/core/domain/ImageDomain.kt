package io.github.rookie_leo.imageliteapi.core.domain

import java.time.LocalDateTime

data class ImageDomain(
    val id: String? = null,
    val name: String,
    val size: Long,
    val extension: ImageExtension,
    val uploadDate: LocalDateTime? = null,
    val tags: String,
    val file: ByteArray
)
