package guru.springframework.spring5webapp.bootstrap

import guru.springframework.spring5webapp.model.Author
import guru.springframework.spring5webapp.model.Book
import guru.springframework.spring5webapp.repositories.AuthorRepository
import guru.springframework.spring5webapp.repositories.BookRepository
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class DevBootstrap (
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository
) : ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(event: ContextRefreshedEvent?) {
        initData()
    }

    private fun initData() {
        //Eric
        val eric = Author("Eric", "Evans")
        val ddd = Book("Domain Driven Design", "1234", "Harper Collins")
        eric.books.add(ddd)
        ddd.authors.add(eric)

        authorRepository.save(eric)
        bookRepository.save(ddd)

        //Rod
        val rod = Author("Rod", "Johnson")
        val noEJB = Book("J2EE Development without EJB", "23444", "Wrox")
        rod.books.add(noEJB)

        authorRepository.save(rod)
        bookRepository.save(noEJB)
    }
}
