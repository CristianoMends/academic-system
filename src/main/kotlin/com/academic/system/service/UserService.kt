package com.academic.system.service

import com.academic.system.entity.Course
import com.academic.system.entity.Users
import com.academic.system.repository.CourseRepository
import com.academic.system.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    val userRepository: UserRepository,
    val courseRepository: CourseRepository
) {

    fun login(email:String, password:String):Users?{
         return userRepository.findByEmailAndPassword(email=email, password = password)
    }
    fun registerUser(users:Users):Users{
        val course:Course? = when(users.courseName){
            "ES" -> Course(name = "ES", courseId = 1)
            "EC" -> Course(name = "EC", courseId = 2)
            "RC" -> Course(name = "RC", courseId = 3)
            "SI" -> Course(name = "SI", courseId = 4)
            "CC" -> Course(name = "CC", courseId = 5)
            "DD" -> Course(name = "DD", courseId = 6)
            else -> null
        }
        if (course == null) {throw RuntimeException("erro: curso inexistente")}

        if (courseRepository.findByName(users.courseName) == null){
            val coursSaved: Course = courseRepository.save(course)
        }
        users.course = course
        return userRepository.save(users)
    }

}