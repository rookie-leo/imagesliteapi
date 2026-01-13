package io.github.rookie_leo.imageliteapi.adapters.exceptions.cod_errors

enum class ErrorCodes(val cod: String) {
    COD_DB_ERROR_SAVE("Failed to save to database."),
    COD_DB_ERROR_CONNECTION("Failed to connect to database."),
    COD_DB_ERROR_READ("Failed to read to database"),

    COD_VALIDATION_ERROR("VALIDATION_ERROR"),

    COD_GENERIC_ERROR("Has a generic error")

}