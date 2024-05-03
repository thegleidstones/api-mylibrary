package silvadev.com.br.mylibrary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import silvadev.com.br.mylibrary.domain.bookLoan.BookLoan;
import silvadev.com.br.mylibrary.domain.bookLoanItem.BookLoanItem;
import silvadev.com.br.mylibrary.dto.bookLoan.BookLoanIdDTO;
import silvadev.com.br.mylibrary.dto.bookLoan.BookLoanRequestDTO;
import silvadev.com.br.mylibrary.services.BookLoanService;

import java.util.List;

@RestController
@RequestMapping("/book-loans")
@RequiredArgsConstructor
public class BookLoanController {
    private final BookLoanService bookLoanService;

    @GetMapping("/{id}")
    public ResponseEntity<BookLoan> getBookLoan(@PathVariable String id) {
        return ResponseEntity.ok(this.bookLoanService.getBookLoan(id));
    }

    @GetMapping
    public ResponseEntity<List<BookLoan>> getBookLoan() {
        return ResponseEntity.ok(this.bookLoanService.getBookLoan());
    }

    @PostMapping
    public ResponseEntity<BookLoanIdDTO> createBookLoan(@RequestBody BookLoanRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        BookLoanIdDTO bookLoanIdDTO = this.bookLoanService.createBookLoan(body);

        var uri = uriComponentsBuilder.path("/book-loans/{id}").buildAndExpand(bookLoanIdDTO.bookLoanId()).toUri();

        return ResponseEntity.created(uri).body(bookLoanIdDTO);
    }

    @PostMapping("/test")
    public ResponseEntity<BookLoanRequestDTO> test(@RequestBody BookLoanRequestDTO body) {
        return ResponseEntity.ok(body);
    }
}
