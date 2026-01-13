package io.github.rookie_leo.imageliteapi.adapters.exceptions

data class ApiErrorResponse(
    val errors: List<ApiError>
)

data class ApiError(
    val cod: String,
    val message : String,
    val details: ErrorDetail? = null
)

data class ErrorDetail(
    val field: String,
    val message: String
)