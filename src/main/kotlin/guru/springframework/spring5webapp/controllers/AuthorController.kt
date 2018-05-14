package guru.springframework.spring5webapp.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import guru.springframework.spring5webapp.repositories.AuthorRepository

@Controller
class AuthorController(val authorRepository: AuthorRepository) {
    @RequestMapping("/authors")
    fun getBooks(model: Model): String {
        model.addAttribute("authors", authorRepository.findAll())
        return "authors" // View name
    }
}
