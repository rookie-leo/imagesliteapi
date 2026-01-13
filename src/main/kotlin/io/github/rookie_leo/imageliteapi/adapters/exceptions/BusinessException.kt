package io.github.rookie_leo.imageliteapi.adapters.exceptions

class BusinessException(
    val cod: String,
    override val message: String,
    val details: ErrorDetail? = null
) : RuntimeException(message)