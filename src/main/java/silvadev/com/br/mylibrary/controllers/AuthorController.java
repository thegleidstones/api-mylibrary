package silvadev.com.br.mylibrary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import silvadev.com.br.mylibrary.domain.author.Author;
import silvadev.com.br.mylibrary.dto.author.AuthorIdDTO;
import silvadev.com.br.mylibrary.dto.author.AuthorRequestDTO;
import silvadev.com.br.mylibrary.services.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable String id) {
        Author author = this.authorService.getAuthor(id);
        return ResponseEntity.ok(author);
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAuthor() {
        List<Author> authorList = this.authorService.getAuthor();
        return ResponseEntity.ok(authorList);
    }

    @PostMapping
    public ResponseEntity<AuthorIdDTO> createAuthor(@RequestBody AuthorRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        AuthorIdDTO authorId = this.authorService.createAuthor(body);

        var uri = uriComponentsBuilder.path("/authors/{id}").buildAndExpand(authorId.authorId()).toUri();

        return ResponseEntity.created(uri).body(authorId);
    }
}
