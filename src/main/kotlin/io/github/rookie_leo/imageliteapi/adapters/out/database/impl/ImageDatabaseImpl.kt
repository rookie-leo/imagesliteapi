package io.github.rookie_leo.imageliteapi.adapters.out.database.impl

import io.github.rookie_leo.imageliteapi.adapters.exceptions.DataBaseConectionException
import io.github.rookie_leo.imageliteapi.adapters.out.database.ImageDatabase
import io.github.rookie_leo.imageliteapi.adapters.out.database.entities.ImageEntity
import io.github.rookie_leo.imageliteapi.adapters.out.database.repositories.ImageRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class ImageDatabaseImpl(
    private val repository: ImageRepository
) : ImageDatabase {
    @Transactional
    override fun save(image: ImageEntity): ImageEntity =
        try {
            repository.save(image)
        } catch (ex: Exception) {
            throw DataBaseConectionException("Has a error connection with database", ex.cause)
        }

    override fun findById(id: String): ImageEntity? =
        try {
            repository.findById(id).orElse(null)
        } catch (ex: Exception) {
            throw DataBaseConectionException("Has a error connection with database", ex.cause)
        }

}