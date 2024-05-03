package silvadev.com.br.mylibrary.domain.bookCopy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import silvadev.com.br.mylibrary.domain.book.Book;
import silvadev.com.br.mylibrary.domain.publisher.Publisher;

import java.time.LocalDateTime;

@Entity
@Table(name = "book_copies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCopy {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @Column(name = "isbn_code", nullable = false, unique = true)
    private String isbnCode;

    private String edition;

    @Column(name = "edition_date")
    private LocalDateTime editionDate;

    @Column(name = "acquisition_at")
    private LocalDateTime acquisitionAt;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
