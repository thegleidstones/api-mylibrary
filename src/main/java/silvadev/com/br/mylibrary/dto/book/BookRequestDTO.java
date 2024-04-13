package silvadev.com.br.mylibrary.dto.book;

import silvadev.com.br.mylibrary.domain.author.Author;

public record BookRequestDTO(String title, Author author) {
}
