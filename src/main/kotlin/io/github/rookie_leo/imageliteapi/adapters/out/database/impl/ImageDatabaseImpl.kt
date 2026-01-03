package io.github.rookie_leo.imageliteapi.adapters.out.database.impl

import io.github.rookie_leo.imageliteapi.adapters.exceptions.DataBaseConectionException
import io.github.rookie_leo.imageliteapi.adapters.out.database.ImageDatabase
import io.github.rookie_leo.imageliteapi.adapters.out.database.entities.ImageEntity
import io.github.rookie_leo.imageliteapi.adapters.out.database.repositories.ImageRepository
import io.github.rookie_leo.imageliteapi.core.domain.ImageExtension
import jakarta.persistence.EntityManager
import jakarta.persistence.criteria.Predicate
import jakarta.transaction.Transactional
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Component

@Component
class ImageDatabaseImpl(
    private val repository: ImageRepository,
    private val entityManager: EntityManager
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

    override fun search(
        extension: ImageExtension?,
        query: String?
    ): List<ImageEntity> {
        val spec = Specification<ImageEntity> {root, _, cb ->
            val predicates = mutableListOf<Predicate>()

            extension?.let {
                predicates += cb.equal(root.get<ImageExtension>("extension"), it)
            }

            if(!query.isNullOrBlank()) {
                val like = "%${query.lowercase()}%"
                predicates += cb.or(
                    cb.like(cb.lower(root.get("name")), like),
                    cb.like(cb.lower(root.get("tags")), like)
                )
            }

            cb.and(*predicates.toTypedArray())
        }

        return repository.findAll(spec)
    }
}