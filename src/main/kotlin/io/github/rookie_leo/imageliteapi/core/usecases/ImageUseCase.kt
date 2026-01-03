package io.github.rookie_leo.imageliteapi.core.usecases

import io.github.rookie_leo.imageliteapi.core.domain.ImageDomain

interface ImageUseCase {
    fun save(image: ImageDomain): ImageDomain
    fun getById(id: String): ImageDomain?
}