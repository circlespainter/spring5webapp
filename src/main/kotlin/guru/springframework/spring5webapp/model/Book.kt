package guru.springframework.spring5webapp.model

import javax.persistence.*

@Entity
data class Book (
    var title: String,
    var isbn: String,

    @OneToOne
    var publisher: Publisher,

    @ManyToMany
    @JoinTable (
        name = "author_book",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")]
    )
    val authors: MutableSet<Author> = mutableSetOf(),

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
) {
    override fun equals(other: Any?) = other is Book && id == other.id

    override fun hashCode() = id?.hashCode() ?: 0
}
