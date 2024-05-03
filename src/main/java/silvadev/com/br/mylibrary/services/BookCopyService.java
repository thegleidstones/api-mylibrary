package silvadev.com.br.mylibrary.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import silvadev.com.br.mylibrary.domain.bookCopy.BookCopy;
import silvadev.com.br.mylibrary.domain.bookCopy.exceptions.BookCopyNotFoundException;
import silvadev.com.br.mylibrary.dto.bookCopy.BookCopyIdDTO;
import silvadev.com.br.mylibrary.dto.bookCopy.BookCopyRequestDTO;
import silvadev.com.br.mylibrary.repositories.BookCopyRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookCopyService {
    private final BookCopyRepository bookCopyRepository;

    public BookCopy getBookCopy(String id) {
        return this.bookCopyRepository.findById(id).orElseThrow(
                () -> new BookCopyNotFoundException("Book copy not found with ID: " + id));
    }

    public List<BookCopy> getBookCopy() {
        return this.bookCopyRepository.findAll();
    }

    public BookCopyIdDTO createBookCopy(BookCopyRequestDTO dto) {
        BookCopy bookCopy = new BookCopy();
        bookCopy.setBook(dto.book());
        bookCopy.setPublisher(dto.publisher());
        bookCopy.setIsbnCode(dto.isbnCode());
        bookCopy.setEdition(dto.edition());
        bookCopy.setEditionDate(dto.editionDate());
        bookCopy.setAcquisitionAt(dto.acquisitionAt());
        bookCopy.setIsActive(true);
        bookCopy.setCreatedAt(LocalDateTime.now());

        this.bookCopyRepository.save(bookCopy);

        return new BookCopyIdDTO(bookCopy.getId());
    }
}
