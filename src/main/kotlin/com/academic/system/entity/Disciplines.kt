package com.academic.system.entity

import com.academic.system.enums.DisciplineStatus
import jakarta.persistence.*

@Entity
data class Disciplines(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val disciplineId: Long,
    val name: String,
    val workload: Int,
    val credits: Int,
    val status: String = DisciplineStatus.INPROGRESS.toString(),
    val semester: Int,
    val grade: Float?,

    @ManyToMany(mappedBy = "disciplines")
    val courses: Set<Course> = HashSet()
)