package io.github.rookie_leo.imageliteapi.core.utils

import io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos.ImageResponse
import io.github.rookie_leo.imageliteapi.adapters.out.database.entities.ImageEntity
import io.github.rookie_leo.imageliteapi.core.domain.ImageDomain

fun ImageDomain.toEntity(): ImageEntity =
    ImageEntity(
        name = name,
        tags = tags.toString(),
        size = size,
        extension = extension,
        file = file
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

fun ImageDomain.toResponse(): ImageResponse =
    ImageResponse(
        id!!,
        name,
        size,
        extension,
        uploadDate!!,
        tags,
        file
    )