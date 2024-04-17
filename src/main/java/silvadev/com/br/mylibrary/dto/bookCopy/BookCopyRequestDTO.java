package silvadev.com.br.mylibrary.dto.bookCopy;

import silvadev.com.br.mylibrary.domain.book.Book;
import silvadev.com.br.mylibrary.domain.publisher.Publisher;

import java.time.LocalDateTime;

public record BookCopyRequestDTO(
        Book book,
        Publisher publisher,
        String isbnCode,
        String edition,
        LocalDateTime editionDate,
        LocalDateTime acquisitionAt
    ) {
}
