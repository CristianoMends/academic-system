package com.academic.system.Controller

import com.academic.system.dto.LoginDto
import com.academic.system.dto.LoginView
import com.academic.system.dto.UserDto
import com.academic.system.dto.UserView
import com.academic.system.entity.Course
import com.academic.system.repository.CourseRepository
import com.academic.system.repository.UserRepository
import com.academic.system.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    val userService: UserService,
    val viewController: ViewController

) {

    @PostMapping("/register/user")
    fun registerUser(@RequestBody @Valid userDto: UserDto): ResponseEntity<UserView> {
        val savedUser = this.userService.registerUser(userDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body(UserView(savedUser))
    }

    @PostMapping("/login")
    fun login(@RequestBody @Valid loginDto: LoginDto): ResponseEntity<LoginView>{
        val user = userService.login(loginDto.email,loginDto.password)

        if (user != null){
            return ResponseEntity.status(HttpStatus.OK).body(LoginView(user))
        }else{
            return ResponseEntity.notFound().build()
        }
    }

}