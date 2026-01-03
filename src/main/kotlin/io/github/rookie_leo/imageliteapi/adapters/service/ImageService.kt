package io.github.rookie_leo.imageliteapi.adapters.service

import io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos.ImageRequest
import io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos.ImageResponse
import io.github.rookie_leo.imageliteapi.core.domain.ImageExtension

interface ImageService {
    fun save(image: ImageRequest): ImageResponse
    fun getById(id: String): ImageResponse?
    fun search(extension: ImageExtension?, query: String?): List<ImageResponse>
}