package com.academic.system.Controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ViewController {

    @RequestMapping("/index")
    fun view():String = "login/index"

    @RequestMapping("/register")
    fun viewRegister():String = "register/register"

    @RequestMapping("/main")
    fun viewMain():String = "main/main"
}