package com.academic.system.dto

import com.academic.system.entity.Disciplines

data class DisciplineView2(
    val name: String,
    val time: String,
    val day: String,
    val grade: Float?
) {
    constructor(discipline: Disciplines) : this(
        name = discipline.name,
        time = discipline.time,
        day = discipline.day,
        grade = discipline.grade
    )
}