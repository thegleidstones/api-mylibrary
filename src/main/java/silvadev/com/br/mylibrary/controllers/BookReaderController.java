package silvadev.com.br.mylibrary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import silvadev.com.br.mylibrary.domain.bookReader.BookReader;
import silvadev.com.br.mylibrary.dto.bookReader.BookReaderIdDTO;
import silvadev.com.br.mylibrary.dto.bookReader.BookReaderRequestDTO;
import silvadev.com.br.mylibrary.services.BookReaderService;

import java.util.List;

@RestController
@RequestMapping("/book-readers")
@RequiredArgsConstructor
public class BookReaderController {
    private final BookReaderService bookReaderService;

    @GetMapping("/{id}")
    public ResponseEntity<BookReader> getBookReader(@PathVariable String id) {
        return ResponseEntity.ok(this.bookReaderService.getBookReader(id));
    }

    @GetMapping
    public ResponseEntity<List<BookReader>> getBookReader() {
        return  ResponseEntity.ok(this.bookReaderService.getBookReader());
    }

    @PostMapping
    public ResponseEntity<BookReaderIdDTO> createBookReader(@RequestBody BookReaderRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        BookReaderIdDTO bookReaderIdDTO = this.bookReaderService.createBookReader(body);

        var uri = uriComponentsBuilder.path("/book-readers/{id}").buildAndExpand(bookReaderIdDTO.bookReaderId()).toUri();

        return ResponseEntity.created(uri).body(bookReaderIdDTO);
    }
}
