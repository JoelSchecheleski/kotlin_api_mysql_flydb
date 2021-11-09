package com.mercadolivro.exception

import com.mercadolivro.controller.response.exceptionResponse.ErrorResponse
import com.mercadolivro.controller.response.exceptionResponse.FieldErrorResponse
import com.mercadolivro.enums.Errors
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest


@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
            ex.errorCode,
            null
        )
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(ex: BadRequestException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            ex.errorCode,
            null
        )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException, request: WebRequest):
            ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            Errors.ML001.message,
            Errors.ML001.code,
            ex.bindingResult.fieldErrors.map {
                FieldErrorResponse(it.defaultMessage ?: "invalid", it.field)
            }
        )
        return ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY)
    }

//    @ExceptionHandler(ConstraintViolationException::class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    fun onConstraintValidationException(
//        e: ConstraintViolationException
//    ): ValidationErrorResponse? {
//        val error = ValidationErrorResponse()
//        for (violation in e.getConstraintViolations()) {
//            error.getViolations().add(
//                Violation(violation.getPropertyPath().toString(), violation.getMessage())
//            )
//        }
//        return error
//    }

//    @ExceptionHandler(
//        ConstraintViolationException::class,
//        HttpClientErrorException.BadRequest::class,
//        MethodArgumentNotValidException::class,
//        MissingServletRequestParameterException::class,
//        IllegalArgumentException::class
//    )
//    fun constraintViolationException(e: Exception): ResponseEntity<ErrorResponse> {
//        val error = ErrorResponse(
//            400,
//            "Bad request",
//            "0001",
//            listOf()
//        )
//        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
//    }


//    @ExceptionHandler(AuthorizationException::class)
//    fun unauthorizedException(e: Exception): ResponseEntity<ErrorResponse> {
//        return generateErrorResponse(HttpStatus.FORBIDDEN, "You are not authorized to do this operation", e)
//    }

//    @ExceptionHandler(AuthenticationException::class)
//    fun forbiddenException(e: Exception): ResponseEntity<ErrorResponse> {
//        return generateErrorResponse(HttpStatus.UNAUTHORIZED, "You are not allowed to do this operation", e)
//    }

//    @ExceptionHandler(
//        EntityNotFoundException::class,
//        NoSuchElementException::class,
//        NoResultException::class,
//        EmptyResultDataAccessException::class,
//        IndexOutOfBoundsException::class,
//        KotlinNullPointerException::class
//    )
//    fun notFoundException(e: Exception): ResponseEntity<ErrorResponse> {
//        return generateErrorResponse(HttpStatus.NOT_FOUND, "Resource not found", e)
//    }

//    @ExceptionHandler(
//        Exception::class
//    )
//    fun internalServerErrorException(e: Exception): ResponseEntity<ErrorResponse> {
//        return generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Generic internal error", e)
//    }

//    private fun generateErrorResponse(
//        status: HttpStatus,
//        message: String,
//        e: Exception
//    ): ResponseEntity<ErrorResponse> {
//        // converting the exception stack trace to a string
//        val sw = StringWriter()
//        val pw = PrintWriter(sw)
//        e.printStackTrace(pw)
//        val stackTrace = sw.toString()

        // example: logging the stack trace
        // log.debug(stackTrace)

        // environment-based logic
//        val stackTraceMessage: String? =
//            when (System.getenv("ENV").toUpperCase()) {
//                "STAGING" -> stackTrace // returning the stack trace
//                "PRODUCTION" -> null // returning no stack trace
//                else -> stackTrace // default behavior
//            }

//        return ResponseEntity(
//            ErrorResponse(
//                HttpStatus.NOT_FOUND.value(),
//                message,
//                "00001",
//                stackTraceMessage!!.toList(),
//            ), status)
//    }

}