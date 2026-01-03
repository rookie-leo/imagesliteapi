package io.github.rookie_leo.imageliteapi.core.usecases.impl

import io.github.rookie_leo.imageliteapi.adapters.out.database.ImageDatabase
import io.github.rookie_leo.imageliteapi.core.domain.ImageDomain
import io.github.rookie_leo.imageliteapi.core.domain.ImageExtension
import io.github.rookie_leo.imageliteapi.core.usecases.ImageUseCase
import io.github.rookie_leo.imageliteapi.core.utils.toDomain
import io.github.rookie_leo.imageliteapi.core.utils.toEntity

class ImageUseCaseImpl(
    val database: ImageDatabase
): ImageUseCase {
    override fun save(image: ImageDomain): ImageDomain =
        database.save(image.toEntity()).toDomain()

    override fun getById(id: String): ImageDomain? =
        database.findById(id)?.toDomain()

    override fun search(
        extension: ImageExtension?,
        query: String?
    ): List<ImageDomain> =
        database.search(extension, query).map { image ->
            image.toDomain()
        }
}




