package io.github.rookie_leo.imageliteapi.adapters.service

import io.github.rookie_leo.imageliteapi.adapters.out.repositories.entities.ImageEntity

interface ImageService {
    fun save(image: ImageEntity): ImageEntity
}