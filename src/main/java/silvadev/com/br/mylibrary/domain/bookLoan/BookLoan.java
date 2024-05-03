package silvadev.com.br.mylibrary.domain.bookLoan;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import silvadev.com.br.mylibrary.domain.bookLoanItem.BookLoanItem;
import silvadev.com.br.mylibrary.domain.bookReader.BookReader;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book_loans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookLoan {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "loan_date", nullable = false)
    private LocalDateTime loanDate;

    @Column(name = "devolution_date")
    private LocalDateTime devolutionDate;

    @ManyToOne
    @JoinColumn(name = "book_reader_id", nullable = false)
    private BookReader bookReader;

    @OneToMany(mappedBy = "bookLoan")
    private List<BookLoanItem> bookLoanItems = new ArrayList<>();

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
