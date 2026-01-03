package io.github.rookie_leo.imageliteapi.core.domain

import org.springframework.http.MediaType
import java.util.Arrays

enum class ImageExtension(val imageExtension: MediaType) {
    PNG(MediaType.IMAGE_PNG),
    GIF(MediaType.IMAGE_GIF),
    JPEG(MediaType.IMAGE_JPEG);

    companion object {
        fun fromMediaType(mediaType: MediaType): ImageExtension =
            values().firstOrNull { it.imageExtension == mediaType }
                ?: throw IllegalArgumentException("Unsupported media type: $mediaType")

        fun ofName(name: String): ImageExtension? =
            Arrays.stream(ImageExtension.entries.toTypedArray())
                .filter { ie -> ie.name == name }
                .findFirst()
                .orElse(null)
    }

}