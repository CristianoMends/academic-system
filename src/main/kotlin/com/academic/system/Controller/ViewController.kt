package com.academic.system.Controller

import com.academic.system.dto.UserView
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import com.academic.system.Controller.UserController.CurrentUser

@Controller
class ViewController{

    @RequestMapping("/")
    fun viewHome(model: Model):String{

        val user: UserView? = CurrentUser.user

        if(user == null) {
            model.addAttribute("btnLoginOut","btnLogin")
            model.addAttribute("userName", "...")
            model.addAttribute("loginOut","Login")

        }else{
            model.addAttribute("btnLoginOut","btnLogout")
            model.addAttribute("userName",user.name)
            model.addAttribute("loginOut","Logout")

        }
        return "pages/home"
    }

    @RequestMapping("/register")
    fun viewRegister():String = "pages/register"

    @RequestMapping("/login")
    fun viewLogin():String = "pages/login"

    @RequestMapping("/logout")
    fun viewLogout():String{
        CurrentUser.user = null
        return "pages/login"
    }

    @RequestMapping("/forum")
    fun viewForum(model: Model):String{

        val user: UserView? = CurrentUser.user

        if(user == null) {
            model.addAttribute("userName", "...")
        }else{
            model.addAttribute("userName",user.name)
        }

        return "pages/forum"
    }

    @RequestMapping("/profile")
    fun viewProfile(model: Model): String {

        val user: UserView? = CurrentUser.user

        if(user == null) {
            model.addAttribute("userName", "...")
            model.addAttribute("loginOut","Login")
        }else{
            model.addAttribute("userName",user.name)
            model.addAttribute("loginOut","Logout")

        }

        return "pages/profile"
    }

}