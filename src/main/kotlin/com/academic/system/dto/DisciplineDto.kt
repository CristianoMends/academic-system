package com.academic.system.dto

import com.academic.system.entity.Course
import com.academic.system.entity.Disciplines
import com.academic.system.entity.Users
import com.academic.system.enums.DisciplineStatus
import com.academic.system.enums.UserPermission
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class DisciplineDto (
    @field:NotNull(message = "invalid input") val disciplineId: Long,
    @field:NotNull(message = "invalid input") val name: String,
    @field:NotNull(message = "invalid input") val time: String,
    @field:NotNull(message = "invalid input") val day: String,
    @field:NotNull(message = "invalid input") val place: String,

    ){
    fun toEntity(): Disciplines = Disciplines(
        disciplineId = this.disciplineId,
        name = this.name,
        time = this.time,
        place = this.place,
        day = this.day,
    )
}