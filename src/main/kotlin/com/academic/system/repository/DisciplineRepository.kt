package com.academic.system.repository

import com.academic.system.entity.Disciplines
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DisciplineRepository:JpaRepository<Disciplines,Long> {

    @Query(value =
            "select d.* from disciplines d                                          \n" +
            "inner join courses_disciplines cd on d.discipline_id = cd.discipline_id\n" +
            "inner join course c on c.course_id = cd.course_id                      \n" +
            "where c.name = '?1'",
        nativeQuery = true)
    fun findAllByCourseName(courseName:String):List<Disciplines>
}