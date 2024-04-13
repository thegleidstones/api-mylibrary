package silvadev.com.br.mylibrary.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import silvadev.com.br.mylibrary.domain.book.Book;
import silvadev.com.br.mylibrary.domain.book.exceptions.BookNotFoundException;
import silvadev.com.br.mylibrary.dto.book.BookIdDTO;
import silvadev.com.br.mylibrary.dto.book.BookRequestDTO;
import silvadev.com.br.mylibrary.repositories.BookRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getBook() {
        return this.bookRepository.findAll();
    }

    public Book getBook(String bookId) {
        return this.bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book not found with ID: "  + bookId));
    }

    public BookIdDTO createBook(BookRequestDTO bookDTO) {
        Book newBook = new Book();
        newBook.setTitle(bookDTO.title());
        newBook.setAuthor(bookDTO.author());
        newBook.setCreatedAt(LocalDateTime.now());

        this.bookRepository.save(newBook);

        return new BookIdDTO(newBook.getId());
    }


}
