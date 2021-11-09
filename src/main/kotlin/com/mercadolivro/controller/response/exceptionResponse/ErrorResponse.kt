package com.mercadolivro.controller.response.exceptionResponse

data class ErrorResponse(
    val httpCode: Int,
    val message: String,
    val internalCode: String,
    val errors: List<FieldErrorResponse>?
)