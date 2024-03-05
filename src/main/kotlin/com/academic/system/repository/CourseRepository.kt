package com.academic.system.repository

import com.academic.system.entity.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository:JpaRepository<Course, Long> {

    @Query(value = "select * from course where name=?1 limit 1", nativeQuery = true)
    fun findByName(name:String):Course?
}