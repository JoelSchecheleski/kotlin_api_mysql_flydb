package com.mercadolivro.controller.response.exceptionResponse

data class FieldErrorResponse(
    var message: String,
    var field: String
)