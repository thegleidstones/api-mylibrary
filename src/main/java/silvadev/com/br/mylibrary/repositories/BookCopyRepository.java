package silvadev.com.br.mylibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import silvadev.com.br.mylibrary.domain.bookCopy.BookCopy;

public interface BookCopyRepository extends JpaRepository<BookCopy, String> {
}
