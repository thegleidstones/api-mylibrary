package silvadev.com.br.mylibrary.domain.bookLoanItem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import silvadev.com.br.mylibrary.domain.bookCopy.BookCopy;
import silvadev.com.br.mylibrary.domain.bookLoan.BookLoan;

import java.time.LocalDateTime;

@Entity
@Table(name = "book_loan_items")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookLoanItem {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "book_loan_id")
    @JsonIgnore
    private BookLoan bookLoan;

    @ManyToOne
    @JoinColumn(name = "book_copy_id")
    private BookCopy bookCopy;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
