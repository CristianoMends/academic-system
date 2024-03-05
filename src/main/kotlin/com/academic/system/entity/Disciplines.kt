package com.academic.system.entity

import com.academic.system.enums.DisciplineStatus
import jakarta.persistence.*

@Entity
data class Disciplines(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val disciplineId: Long,
    val name: String,
    val time: String,
    val day: String,
    val place: String,
    val status: String = DisciplineStatus.INPROGRESS.toString(),
    val grade: Float? = null,

    @ManyToMany(mappedBy = "disciplines")
    val courses: Set<Course> = HashSet()
)