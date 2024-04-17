package silvadev.com.br.mylibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import silvadev.com.br.mylibrary.domain.bookReader.BookReader;

public interface BookReaderRepository extends JpaRepository<BookReader, String> {
}
