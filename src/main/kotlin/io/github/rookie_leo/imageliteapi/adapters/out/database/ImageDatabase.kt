package io.github.rookie_leo.imageliteapi.adapters.out.database

import io.github.rookie_leo.imageliteapi.adapters.`in`.controllers.dtos.ImageResponse
import io.github.rookie_leo.imageliteapi.adapters.out.database.entities.ImageEntity

interface ImageDatabase {
    fun save(image: ImageEntity): ImageEntity
    fun findById(id: String): ImageEntity?
}