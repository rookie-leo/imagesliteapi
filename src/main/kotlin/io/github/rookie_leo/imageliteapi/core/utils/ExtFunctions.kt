package io.github.rookie_leo.imageliteapi.core.utils

import io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos.ImageRequest
import io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos.ImageResponse
import io.github.rookie_leo.imageliteapi.adapters.out.database.entities.ImageEntity
import io.github.rookie_leo.imageliteapi.core.domain.ImageDomain
import io.github.rookie_leo.imageliteapi.core.domain.ImageExtension
import org.springframework.http.MediaType
import java.net.URI

fun ImageDomain.toEntity(): ImageEntity =
    ImageEntity(
        name = name,
        tags = tags.toString(),
        size = size,
        extension = extension,
        file = file
    )

fun ImageDomain.toResponse(): ImageResponse =
    ImageResponse(
        id!!,
        name,
        size,
        extension,
        uploadDate!!.toLocalDate(),
        tags,
        file
    )

fun ImageEntity.toDomain(): ImageDomain =
    ImageDomain(
        id,
        name,
        size,
        extension,
        uploadDate,
        tags,
        file
    )

fun ImageRequest.toDomain(): ImageDomain =
    ImageDomain(
        name = name,
        size = file.size,
        extension = ImageExtension.fromMediaType(resolveMediaType()),
        tags = tags.joinToString(","),
        file = file.bytes
    )

private fun ImageRequest.resolveMediaType(): MediaType =
    file.contentType
        ?.let { MediaType.parseMediaType(it) }
        ?: throw IllegalArgumentException("File content type is required")

fun ImageResponse.withImageUri(uri: URI): ImageResponse =
    this.copy(imageUri = uri)