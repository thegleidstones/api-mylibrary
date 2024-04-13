package silvadev.com.br.mylibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import silvadev.com.br.mylibrary.domain.author.Author;

public interface AuthorRepository extends JpaRepository<Author, String> {
}
