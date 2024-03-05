package com.academic.system.Controller

import com.academic.system.dto.DisciplineDto
import com.academic.system.dto.DisciplineView
import com.academic.system.service.DisciplineService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DisciplineController(
    val disciplineService: DisciplineService
) {

    @PostMapping("/register/disciplines")
    fun registerDiscipline(@RequestBody @Valid disciplineDto: Array<DisciplineDto>): ResponseEntity<List<DisciplineView>> {
        val disciplineViews = mutableListOf<DisciplineView>()

        for (d in disciplineDto) {
            val savedDisciplines = disciplineService.registerDiscipline(d.toEntity())
            val disciplineView = DisciplineView(savedDisciplines)
            disciplineViews.add(disciplineView)
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(disciplineViews)
    }
    @GetMapping("/disciplines")
    fun getDiscipline(): ResponseEntity<List<DisciplineView>> {
        val disciplineViews = mutableListOf<DisciplineView>()

        // Recupera as disciplinas para o usuário atual
        val currentUser = UserController.CurrentUser.user
        if (currentUser != null) {
            val savedDisciplines = disciplineService.findDisciplinesByUserId(currentUser.userId)
            for (discipline in savedDisciplines) {
                val disciplineView = DisciplineView(discipline)
                disciplineViews.add(disciplineView)
            }
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(disciplineViews)
    }

}