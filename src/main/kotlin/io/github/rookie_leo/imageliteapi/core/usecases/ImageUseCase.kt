package io.github.rookie_leo.imageliteapi.core.usecases

import io.github.rookie_leo.imageliteapi.core.domain.ImageDomain
import io.github.rookie_leo.imageliteapi.core.domain.ImageExtension

interface ImageUseCase {
    fun save(image: ImageDomain): ImageDomain
    fun getById(id: String): ImageDomain?
    fun search(extension: ImageExtension?, query: String?): List<ImageDomain>
}