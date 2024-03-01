package com.academic.system.dto

import com.academic.system.entity.Users

data class LoginView(
    val email:String,
    val password:String
){
    constructor(user: Users) : this(
        email = user.email,
        password = user.password
    )
}
