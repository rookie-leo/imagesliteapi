package io.github.rookie_leo.imageliteapi.adapters.service.impl

import io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos.ImageRequest
import io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos.ImageResponse
import io.github.rookie_leo.imageliteapi.adapters.service.ImageService
import io.github.rookie_leo.imageliteapi.core.usecases.ImageUseCase
import io.github.rookie_leo.imageliteapi.core.utils.toDomain
import io.github.rookie_leo.imageliteapi.core.utils.toResponse
import io.github.rookie_leo.imageliteapi.core.utils.withImageUri
import org.springframework.stereotype.Component
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@Component
class ImageServiceImpl(
    val useCase: ImageUseCase
) : ImageService {
    override fun save(image: ImageRequest): ImageResponse {
        val imageDomain = image.toDomain()
        val savedImage = useCase.save(imageDomain)

        return savedImage.toResponse().withImageUri(buildImageUri(savedImage.id!!))
    }

    override fun getById(id: String): ImageResponse? =
        useCase.getById(id)?.toResponse()

    private fun buildImageUri(imageId: String): URI =
        ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(imageId)
            .toUri()

}