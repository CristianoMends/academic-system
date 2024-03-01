package com.academic.system.repository

import com.academic.system.entity.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository :JpaRepository<Users,Long>{

    @Query(value = "select u.* from users u\n" +
            "where email=?1 and password=?2\n" +
            "limit 1", nativeQuery = true)
    fun findByEmailAndPassword(email:String, password:String):Users?
    fun findAllByCourseName(courseName:String):List<Users>


}