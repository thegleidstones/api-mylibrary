package silvadev.com.br.mylibrary.dto.book;

import silvadev.com.br.mylibrary.domain.author.Author;
import silvadev.com.br.mylibrary.domain.category.Category;

public record BookRequestDTO(String title, Author author, Category category) {
}
