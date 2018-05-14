package guru.springframework.spring5webapp.bootstrap

import guru.springframework.spring5webapp.model.Author
import guru.springframework.spring5webapp.model.Book
import guru.springframework.spring5webapp.model.Publisher
import guru.springframework.spring5webapp.repositories.AuthorRepository
import guru.springframework.spring5webapp.repositories.BookRepository
import guru.springframework.spring5webapp.repositories.PublisherRepository
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class DevBootstrap (
    private val authorRepository: AuthorRepository,
    private val publisherRepository: PublisherRepository,
    private val bookRepository: BookRepository
) : ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(event: ContextRefreshedEvent?) {
        initData()
    }

    private fun initData() {
        //Eric
        val eric = Author("Eric", "Evans")
        val hcp = Publisher("Harper Collins", "Somewhere1")
        val ddd = Book("Domain Driven Design", "1234", hcp)
        eric.books.add(ddd)
        ddd.authors.add(eric)

        authorRepository.save(eric)
        publisherRepository.save(hcp)
        bookRepository.save(ddd)

        //Rod
        val rod = Author("Rod", "Johnson")
        val wp = Publisher("Wrox", "Somewhere2")
        val noEJB = Book("J2EE Development without EJB", "23444", wp)
        rod.books.add(noEJB)

        authorRepository.save(rod)
        publisherRepository.save(wp)
        bookRepository.save(noEJB)
    }
}
