package com.academic.system.dto

import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.UniqueElements

data class LoginDto(
    @field:NotNull(message = "invalid input") val email: String,
    @field:NotNull(message = "invalid input") val password: String
)