package guru.springframework.spring5webapp.model

import javax.persistence.*

@Entity
data class Author (
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,

    var firstName: String,
    var lastName: String,

    @ManyToMany(mappedBy = "authors")
    val books: Set<Book>
) {
    override fun equals(other: Any?) = other is Book && id == other.id

    override fun hashCode() = id.hashCode()
}
