package silvadev.com.br.mylibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import silvadev.com.br.mylibrary.domain.bookLoan.BookLoan;

public interface BookLoanRepository extends JpaRepository<BookLoan, String> {
}
