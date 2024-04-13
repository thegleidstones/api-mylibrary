package silvadev.com.br.mylibrary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import silvadev.com.br.mylibrary.domain.book.Book;
import silvadev.com.br.mylibrary.dto.book.BookIdDTO;
import silvadev.com.br.mylibrary.dto.book.BookRequestDTO;
import silvadev.com.br.mylibrary.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBook() {
        return ResponseEntity.ok(this.bookService.getBook());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id) {
        return ResponseEntity.ok(this.bookService.getBook(id));
    }

    @PostMapping
    public ResponseEntity<BookIdDTO> createBook(@RequestBody BookRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        BookIdDTO bookIdDTO = this.bookService.createBook(body);

        var uri = uriComponentsBuilder.path("/books/{id}").buildAndExpand(bookIdDTO.bookId()).toUri();

        return ResponseEntity.created(uri).body(bookIdDTO);
    }
}
