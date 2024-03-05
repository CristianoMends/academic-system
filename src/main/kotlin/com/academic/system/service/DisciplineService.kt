package com.academic.system.service

import com.academic.system.entity.Course
import com.academic.system.entity.Disciplines
import com.academic.system.entity.Users
import com.academic.system.repository.DisciplineRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Service

@Service
class DisciplineService(val disciplineRepository: DisciplineRepository) {
    fun registerDiscipline(disciplines:Disciplines):Disciplines{
        return disciplineRepository.save(disciplines)
    }

    fun findDisciplinesByUserId(userId:Long):List<Disciplines>{
        return disciplineRepository.findAllByUserId(userId);
    }

}