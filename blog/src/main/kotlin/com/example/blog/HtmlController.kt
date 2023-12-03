package com.example.blog
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Controller
class HtmlController {
    @GetMapping("/")
    fun blog(model: Model):String{
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val current = LocalDateTime.now().format(formatter)
        model["title"] = "TODO List"
        model["username"] = "sam rocky"
        model["date"] = current
        return "blog"
    }
}