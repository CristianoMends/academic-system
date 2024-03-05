package com.academic.system.dto

import com.academic.system.entity.Disciplines

data class DisciplineView(
    val name: String,
    val time: String,
    val day: String
) {
    constructor(discipline: Disciplines) : this(
        name = discipline.name,
        time = discipline.time,
        day = discipline.day
    )
}