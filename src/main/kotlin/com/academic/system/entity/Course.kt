package com.academic.system.entity

import com.academic.system.enums.CoursesNames
import jakarta.persistence.*
import kotlin.collections.HashSet

@Entity
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var courseId: Long? = null,
    val name:String,

    @OneToMany(mappedBy = "course")
    val courseUsers: List<Users> = mutableListOf(),

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "courses_disciplines",
        joinColumns = [JoinColumn(name = "course_id", referencedColumnName = "courseId")],
        inverseJoinColumns = [JoinColumn(name = "discipline_id", referencedColumnName = "disciplineId")])
    val disciplines: Set<Disciplines> = HashSet()
)