package io.github.rookie_leo.imageliteapi.adapters.service

import io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos.ImageRequest
import io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos.ImageResponse

interface ImageService {
    fun save(image: ImageRequest): ImageResponse
}