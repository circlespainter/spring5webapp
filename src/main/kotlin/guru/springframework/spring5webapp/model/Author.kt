package guru.springframework.spring5webapp.model

import javax.persistence.*

@Entity
data class Author (
    var firstName: String,
    var lastName: String,

    @ManyToMany(mappedBy = "authors")
    val books: MutableSet<Book> = mutableSetOf(),

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
) {
    override fun equals(other: Any?) = other is Book && id == other.id

    override fun hashCode() = id?.hashCode() ?: 0
}
