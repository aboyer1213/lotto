package com.example.megamillions.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class HomeController {

    @RequestMapping("/home")
    fun renderHome(model: Model): String{
        model.addAttribute("name", "ANdrew")
        return "home"
    }
}