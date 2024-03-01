package com.academic.system.dto

import com.academic.system.entity.Course
import com.academic.system.entity.Users
import com.academic.system.enums.UserPermission
import com.academic.system.repository.CourseRepository
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.security.Permissions
import java.time.LocalDate
import com.academic.system.repository.CourseRepository as CourseRepository1

data class UserDto(
    @field:NotEmpty(message = "Name cannot be empty")
    val name: String,
    @field:NotEmpty(message = "Name cannot be empty")
    val surname: String?,
    @field:NotEmpty(message = "Email cannot be empty")
    val email: String,
    @field:NotEmpty(message = "Password cannot be empty")
    val password: String,
    @field:NotEmpty(message = "Course name cannot be empty")
    val courseName: String,
    @field:NotNull(message = "Start date cannot be null")
    val startYear: Int,
    @field:NotNull(message = "Start date cannot be null")
    val startSemester:Int,
    @field:NotNull(message = "Registration date cannot be null")
    val userId: Long
){
    fun toEntity(): Users = Users(
        userId = this.userId,
        name = this.name,
        surname = this.surname,
        email = this.email,
        password = this.password,
        courseName = this.courseName,
        startSemester = this.startSemester,
        startYear = this.startYear,
        registrationDate = LocalDate.now(),
        lastAccessDate = LocalDate.now(),
        permissions = UserPermission.USER.toString(),
        course = null
    )
}
