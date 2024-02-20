package com.academic.system.model

import jakarta.persistence.*
import java.util.Date

data class Courses(
    val name:String,
    val totalWorkload:Int,
)