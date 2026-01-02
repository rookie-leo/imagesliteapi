package io.github.rookie_leo.imageliteapi.adapters.out.repositories.entities

import org.springframework.data.jpa.repository.JpaRepository

interface ImageRepository: JpaRepository<ImageEntity, String> {
}