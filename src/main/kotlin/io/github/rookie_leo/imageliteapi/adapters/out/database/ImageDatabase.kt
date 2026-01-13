package io.github.rookie_leo.imageliteapi.adapters.out.database

import io.github.rookie_leo.imageliteapi.adapters.out.database.entities.ImageEntity
import io.github.rookie_leo.imageliteapi.core.domain.ImageExtension
import org.springframework.dao.DataAccessException

interface ImageDatabase {
    fun save(image: ImageEntity): ImageEntity
    fun findById(id: String): ImageEntity?
    fun search(
        extension: ImageExtension?,
        query: String?
    ): List<ImageEntity>
}