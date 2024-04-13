package silvadev.com.br.mylibrary.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import silvadev.com.br.mylibrary.domain.author.Author;
import silvadev.com.br.mylibrary.domain.author.exceptions.AuthorNotFoundException;
import silvadev.com.br.mylibrary.dto.author.AuthorDTO;
import silvadev.com.br.mylibrary.dto.author.AuthorIdDTO;
import silvadev.com.br.mylibrary.dto.author.AuthorRequestDTO;
import silvadev.com.br.mylibrary.repositories.AuthorRepository;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorIdDTO createAuthor(AuthorRequestDTO authorDTO) {
        Author newAuthor = new Author();
        newAuthor.setName(authorDTO.name());

        this.authorRepository.save(newAuthor);

        return new AuthorIdDTO(newAuthor.getId());
    }

    public Author getAuthor(String authorId) {
        return this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException("Author not found with ID: " + authorId));
    }
}
