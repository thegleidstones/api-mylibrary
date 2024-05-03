package silvadev.com.br.mylibrary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import silvadev.com.br.mylibrary.domain.category.Category;
import silvadev.com.br.mylibrary.dto.category.CategoryIdDTO;
import silvadev.com.br.mylibrary.dto.category.CategoryRequestDTO;
import silvadev.com.br.mylibrary.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable String id) {
        return ResponseEntity.ok(this.categoryService.getCategory(id));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getCategory() {
        return ResponseEntity.ok(this.categoryService.getCategory());
    }

    @PostMapping
    public ResponseEntity<CategoryIdDTO> createCategory(@RequestBody CategoryRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        CategoryIdDTO categoryIdDTO = this.categoryService.createCategory(body);

        var uri = uriComponentsBuilder.path("/categories/{id}").buildAndExpand(categoryIdDTO.categoryId()).toUri();

        return ResponseEntity.created(uri).body(categoryIdDTO);
    }

}
