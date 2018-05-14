package guru.springframework.spring5webapp.controllers

import guru.springframework.spring5webapp.repositories.BookRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class BookController(val bookRepository: BookRepository) {
    @RequestMapping("/books")
    fun getBooks(model: Model): String {
        model.addAttribute("books", bookRepository.findAll())
        return "books" // View name
    }
}
