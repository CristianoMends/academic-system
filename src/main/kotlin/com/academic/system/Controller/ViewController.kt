package com.academic.system.Controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ViewController {

    @RequestMapping("/")
    fun viewHome():String = "pages/home"

    @RequestMapping("/register")
    fun viewRegister():String = "pages/register"

    @RequestMapping("/login")
    fun viewLogin():String = "pages/login"

}