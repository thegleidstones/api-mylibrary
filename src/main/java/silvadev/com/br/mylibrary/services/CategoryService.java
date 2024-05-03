package silvadev.com.br.mylibrary.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import silvadev.com.br.mylibrary.domain.category.Category;
import silvadev.com.br.mylibrary.domain.category.exceptions.CategoryNotFoundException;
import silvadev.com.br.mylibrary.dto.category.CategoryIdDTO;
import silvadev.com.br.mylibrary.dto.category.CategoryRequestDTO;
import silvadev.com.br.mylibrary.repositories.CategoryRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryIdDTO createCategory(CategoryRequestDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.name());
        category.setIsActive(true);
        category.setCreatedAt(LocalDateTime.now());

        this.categoryRepository.save(category);

        return new CategoryIdDTO(category.getId());
    }

    public Category getCategory(String categoryId) {
        return this.categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category not found with ID: " + categoryId));
    }

    public List<Category> getCategory() {
        return this.categoryRepository.findAll();
    }
}
