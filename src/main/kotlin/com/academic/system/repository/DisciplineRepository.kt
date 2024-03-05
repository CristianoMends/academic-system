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

    @Query(value = "SELECT d.*\n" +
            "FROM users u\n" +
            "JOIN course c ON u.course_id = c.course_id\n" +
            "JOIN courses_disciplines cd ON c.course_id = cd.course_id\n" +
            "JOIN disciplines d ON cd.discipline_id = d.discipline_id\n" +
            "WHERE u.user_id = ?1;", nativeQuery = true)
    fun findAllByUserId(userId:Long):List<Disciplines>

    @Query(value = "UPDATE public.disciplines\n" +
            "SET grade = <nova_nota>\n" +
            "WHERE discipline_id = <id_disciplina>;\n", nativeQuery = true)
    fun alterGrade(){

    }
}