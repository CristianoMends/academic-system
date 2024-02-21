package com.academic.system.model

import com.academic.system.enums.CoursesNames
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Entity
data class Users(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long,
    var name: String,
    var surname: String?,
    val email: String,
    val password:String,
    val courseName:String = CoursesNames.UNDEFINED.toString(),
    val startDate: LocalDate,
    val registrationDate: LocalDate,
    var lastAccessDate: LocalDate,
    var permissions: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    val course:Course,
)