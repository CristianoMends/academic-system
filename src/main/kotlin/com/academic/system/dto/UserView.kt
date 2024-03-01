package com.academic.system.dto

import com.academic.system.entity.Users
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class UserView(
    val name:               String,
    val surname:            String?,
    val email:              String,
    val password:           String,
    val courseName:         String,
    val startYear:          Int,
    val startSemester:      Int,
    val registrationDate:   LocalDate,
    val lastAccessDate:     LocalDate,
    val permissions:        String,
    val userId:           Long
) { constructor(users:Users): this(
    name = users.name,
    surname = users.surname,
    email = users.email,
    password = users.password,
    courseName = users.courseName,
    startYear = users.startYear,
    startSemester = users.startSemester,
    registrationDate = users.registrationDate,
    lastAccessDate =  users.lastAccessDate,
    permissions = users.permissions,
    userId = users.userId
    )
}
