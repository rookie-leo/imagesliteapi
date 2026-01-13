package io.github.rookie_leo.imageliteapi.adapters.exceptions

import io.github.rookie_leo.imageliteapi.adapters.exceptions.cod_errors.ErrorCodes
import io.github.rookie_leo.imageliteapi.adapters.exceptions.cod_errors.ErrorCodes.COD_DB_ERROR_CONNECTION
import org.springframework.http.ResponseEntity
import org.springframework.transaction.TransactionSystemException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.multipart.support.MissingServletRequestPartException
import java.net.ConnectException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(ex: BusinessException, error: ErrorCodes): ResponseEntity<ApiErrorResponse> =
        ResponseEntity.badRequest().body(
            ApiErrorResponse(
                errors = listOf(
                    ApiError(
                        cod = error.cod,
                        message = ex.message,
                        details = ex.details
                    )
                )
            )
        )

    @ExceptionHandler(DataBaseConectionException::class)
    fun handleDataBaseConectionException(ex: DataBaseConectionException, error: ErrorCodes): ResponseEntity<ApiErrorResponse> =
        ResponseEntity.internalServerError().body(
            ApiErrorResponse(
                errors = listOf(
                    ApiError(
                        cod = error.cod,
                        message = ex.message ?: "Has a error connection with database",
                        details = ex.details
                    )
                )
            )
        )

    @ExceptionHandler(TransactionSystemException::class)
    fun handleTransactionException(
        ex: TransactionSystemException
    ): ResponseEntity<ApiErrorResponse> {
        val cause = ex.rootCause

        if (cause is DataBaseConectionException) {
            return ResponseEntity.internalServerError().body(
                ApiErrorResponse(
                    errors = listOf(
                        ApiError(
                            cod = COD_DB_ERROR_CONNECTION.cod,
                            message = cause.message ?: "Database error",
                            details = cause.details
                        )
                    )
                )
            )
        }

        throw ex
    }

    @ExceptionHandler(MissingServletRequestPartException::class)
    fun handleValidation(ex: MissingServletRequestPartException): ResponseEntity<ApiErrorResponse> =
        ResponseEntity.badRequest().body(
            ApiErrorResponse(
                errors = listOf(
                    ApiError(
                        message = ex.message ?: "Generic message: ${ex.cause}",
                        cod = COD_DB_ERROR_CONNECTION.cod
                    )
                )
            )
        )

    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun handleValidation(ex: MissingServletRequestParameterException): ResponseEntity<ApiErrorResponse> =
        ResponseEntity.badRequest().body(
            ApiErrorResponse(
                errors = listOf(
                    ApiError(
                        message = ex.message ?: "Generic message: ${ex.cause}",
                        cod = COD_DB_ERROR_CONNECTION.cod
                    )
                )
            )
        )

    @ExceptionHandler(ConnectException::class)
    fun handleConnectException(ex: ConnectException): ResponseEntity<ApiErrorResponse> =
        ResponseEntity.internalServerError().body(
            ApiErrorResponse(
                errors = listOf(
                    ApiError(
                        message = ex.message ?: "Generic Exception: ${ex.cause}",
                        cod = COD_DB_ERROR_CONNECTION.cod
                    )
                )
            )
        )

}