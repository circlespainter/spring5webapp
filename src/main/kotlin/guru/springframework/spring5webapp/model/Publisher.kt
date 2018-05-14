package guru.springframework.spring5webapp.model

import javax.persistence.*

@Entity
data class Publisher (
    var name: String,
    var address: String,

    @OneToOne(mappedBy = "publisher")
    var book: Book? = null,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
) {
    override fun equals(other: Any?) = other is Publisher && id == other.id

    override fun hashCode() = id?.hashCode() ?: 0
}
