package com.academic.system.model

import jakarta.persistence.*
import java.util.*

@Entity
data class Users(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long,
    val username:String,
    val password:String,
    val name: String,
    val surname: String,
    val birth: Date,
    val email: String,
    val courseName:String,
    val startDate:Date,
    var registrationDate: Date,
    var lastAccessDate: Date,
    var permissions: String,

    @OneToMany(mappedBy = "user")
    val userDisciplines: List<UsersDisciplines> = mutableListOf()

)