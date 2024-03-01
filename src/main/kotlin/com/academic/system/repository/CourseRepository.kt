package com.academic.system.repository

import com.academic.system.entity.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository:JpaRepository<Course, Long> {
    fun findByName(name:String):Course?
}