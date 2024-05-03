package silvadev.com.br.mylibrary.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import silvadev.com.br.mylibrary.domain.bookReader.BookReader;
import silvadev.com.br.mylibrary.domain.bookReader.exceptions.BookReaderNotFoundException;
import silvadev.com.br.mylibrary.dto.bookReader.BookReaderIdDTO;
import silvadev.com.br.mylibrary.dto.bookReader.BookReaderRequestDTO;
import silvadev.com.br.mylibrary.repositories.BookReaderRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookReaderService {
    private final BookReaderRepository bookReaderRepository;

    public BookReader getBookReader(String id) {
        return this.bookReaderRepository.findById(id).orElseThrow(() -> new BookReaderNotFoundException("Book reader not found with ID: " + id));
    }

    public List<BookReader> getBookReader() {
        return this.bookReaderRepository.findAll();
    }

    public BookReaderIdDTO createBookReader(BookReaderRequestDTO dto) {
        BookReader bookReader = new BookReader();
        bookReader.setName(dto.name());
        bookReader.setEmail(dto.email());
        bookReader.setPhone(dto.phone());
        bookReader.setIsActive(true);
        bookReader.setCreatedAt(LocalDateTime.now());

        this.bookReaderRepository.save(bookReader);

        return new BookReaderIdDTO(bookReader.getId());
    }
}
