package silvadev.com.br.mylibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import silvadev.com.br.mylibrary.domain.book.Book;

public interface BookRepository extends JpaRepository<Book, String> {
}
