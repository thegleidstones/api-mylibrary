package silvadev.com.br.mylibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import silvadev.com.br.mylibrary.domain.category.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
