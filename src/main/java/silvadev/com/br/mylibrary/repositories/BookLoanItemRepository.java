package silvadev.com.br.mylibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import silvadev.com.br.mylibrary.domain.bookLoanItem.BookLoanItem;

public interface BookLoanItemRepository extends JpaRepository<BookLoanItem, String> {
}
