package com.mercadolivro.controller.request

import com.mercadolivro.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest (

    @field:NotEmpty(message = "Nome deve ser informado")
    var name: String,

    @field:Email(message = "Email deve ser váilido")
    @EmailAvailable(message = "Email em uso")
    var email: String,

    @field:NotEmpty(message = "A senha deve ser informada")
    var password: String
)