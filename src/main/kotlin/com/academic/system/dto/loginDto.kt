package com.academic.system.dto

import jakarta.validation.constraints.NotNull

data class loginDto(
    @field:NotNull(message = "invalid input") val nomeUsuario: String,
    @field:NotNull(message = "invalid input") val senha: String
)