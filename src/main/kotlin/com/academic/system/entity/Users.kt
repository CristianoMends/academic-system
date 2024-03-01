package com.academic.system.entity

import com.academic.system.enums.CoursesNames
import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Users(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long,
    var name: String,
    var surname: String?,
    @Column(unique = true)
    val email: String,
    val password:String,
    val courseName:String = CoursesNames.UNDEFINED.toString(),
    val startYear: Int,
    val startSemester:Int,
    val registrationDate: LocalDate,
    var lastAccessDate: LocalDate,
    var permissions: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    var course:Course?,
)