package io.github.rookie_leo.imageliteapi.adapters.service.impl

import io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos.ImageRequest
import io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos.ImageResponse
import io.github.rookie_leo.imageliteapi.adapters.service.ImageService
import io.github.rookie_leo.imageliteapi.core.domain.ImageDomain
import io.github.rookie_leo.imageliteapi.core.domain.ImageExtension
import io.github.rookie_leo.imageliteapi.core.usecases.ImageUseCase
import io.github.rookie_leo.imageliteapi.core.utils.toResponse
import jakarta.transaction.Transactional
import org.springframework.http.MediaType
import org.springframework.stereotype.Component

@Component
class ImageServiceImpl(
    val useCase: ImageUseCase
): ImageService{
    @Transactional
    override fun save(image: ImageRequest): ImageResponse {
        return useCase.save(ImageDomain(
            name = image.name,
            size = image.file.size,
            extension = ImageExtension.fromMediaType(MediaType.valueOf(image.file.contentType.toString())),
            tags = image.tags.toString(),
            file = image.file.bytes
        )).toResponse()
    }
}