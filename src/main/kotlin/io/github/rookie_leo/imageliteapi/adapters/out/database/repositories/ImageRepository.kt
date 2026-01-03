package io.github.rookie_leo.imageliteapi.adapters.out.database.repositories

import io.github.rookie_leo.imageliteapi.adapters.out.database.entities.ImageEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface ImageRepository : JpaRepository<ImageEntity, String>, JpaSpecificationExecutor<ImageEntity> {


}