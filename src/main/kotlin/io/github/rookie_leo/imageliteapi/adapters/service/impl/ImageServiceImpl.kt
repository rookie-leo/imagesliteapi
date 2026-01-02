package io.github.rookie_leo.imageliteapi.adapters.service.impl

import io.github.rookie_leo.imageliteapi.adapters.out.repositories.entities.ImageEntity
import io.github.rookie_leo.imageliteapi.adapters.out.repositories.entities.ImageRepository
import io.github.rookie_leo.imageliteapi.adapters.service.ImageService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class ImageServiceImpl(
    val repository: ImageRepository
): ImageService{
    @Transactional
    override fun save(image: ImageEntity): ImageEntity {
        return repository.save(image)
    }
}