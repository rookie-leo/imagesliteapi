package io.github.rookie_leo.imageliteapi.adapters.out.database.entities

import io.github.rookie_leo.imageliteapi.core.domain.ImageExtension
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(name = "tb_image")
@EntityListeners(AuditingEntityListener::class)
data class ImageEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,

    @Column
    val name: String,

    @Column
    val size: Long,

    @Column
    @Enumerated(EnumType.STRING)
    val extension: ImageExtension,

    @Column
    val uploadDate: LocalDateTime? = LocalDateTime.now(),

    @Column
    val tags: String,

    @Column(name = "file", columnDefinition = "BYTEA")
    val file: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ImageEntity

        if (size != other.size) return false
        if (id != other.id) return false
        if (name != other.name) return false
        if (extension != other.extension) return false
        if (uploadDate != other.uploadDate) return false
        if (tags != other.tags) return false
        if (!file.contentEquals(other.file)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = size.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + extension.hashCode()
        result = 31 * result + uploadDate.hashCode()
        result = 31 * result + tags.hashCode()
        result = 31 * result + file.contentHashCode()
        return result
    }
}
