package silvadev.com.br.mylibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import silvadev.com.br.mylibrary.domain.publisher.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, String > {
}
