package com.mercadolivro.enums

enum class Errors(val code: String, val message: String) {
    ML000("ML-000", "Access Denied"),
    ML001("ML-001", "Invalid Request"),
    ML002("ML-002", "Authorization Service Exception"),
    ML003("ML-003", "You are not allowed to do this operation"),

    ML101("ML-101", "Book [%s] not exists"),
    ML201("ML-201", "Customer [%s] not exists"),
    ML202("ML-202", "Cannot update book with status [%s]")

}