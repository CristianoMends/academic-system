package com.academic.system.model

import com.academic.system.enums.CoursesNames
import jakarta.persistence.*
import java.util.Date
import kotlin.collections.HashSet

@Entity
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var courseId: Long? = null,

    val name:String = CoursesNames.UNDEFINED.toString(),
    val totalWorkload:Int = 0,

    @OneToMany(mappedBy = "course")
    val courseUsers: List<Users> = mutableListOf(),

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "courses_disciplines",
        joinColumns = [JoinColumn(name = "course_id", referencedColumnName = "courseId")],
        inverseJoinColumns = [JoinColumn(name = "discipline_id", referencedColumnName = "disciplineId")])
    val disciplines: Set<Disciplines> = HashSet()
)