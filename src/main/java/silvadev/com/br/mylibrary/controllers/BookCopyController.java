package silvadev.com.br.mylibrary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import silvadev.com.br.mylibrary.domain.bookCopy.BookCopy;
import silvadev.com.br.mylibrary.dto.bookCopy.BookCopyIdDTO;
import silvadev.com.br.mylibrary.dto.bookCopy.BookCopyRequestDTO;
import silvadev.com.br.mylibrary.services.BookCopyService;

import java.util.List;

@RestController
@RequestMapping("/book-copies")
@RequiredArgsConstructor
public class BookCopyController {

    private final BookCopyService bookCopyService;

    @GetMapping("/{id}")
    public ResponseEntity<BookCopy> getBookCopy(@PathVariable String id) {
        return ResponseEntity.ok(this.bookCopyService.getBookCopy(id));
    }

    @GetMapping
    public ResponseEntity<List<BookCopy>> getBookCopy() {
        return ResponseEntity.ok(this.bookCopyService.getBookCopy());
    }

    @PostMapping
    public ResponseEntity<BookCopyIdDTO> createBookCopy(@RequestBody BookCopyRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        BookCopyIdDTO bookCopyIdDTO = this.bookCopyService.createBookCopy(body);

        var uri = uriComponentsBuilder.path("/book-copies/{id}").buildAndExpand(bookCopyIdDTO.bookCopyId()).toUri();

        return ResponseEntity.created(uri).body(bookCopyIdDTO);
    }

}
