package guru.springframework.spring5webapp.repositories

import org.springframework.data.repository.CrudRepository

import guru.springframework.spring5webapp.model.Author

interface AuthorRepository : CrudRepository<Author, Long>
