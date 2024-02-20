package com.academic.system.model

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

    @OneToMany(mappedBy = "discipline")
    val disciplineUsers: List<UsersDisciplines> = mutableListOf()

)