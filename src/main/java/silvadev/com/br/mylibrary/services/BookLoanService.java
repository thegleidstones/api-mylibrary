package silvadev.com.br.mylibrary.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import silvadev.com.br.mylibrary.domain.bookLoan.BookLoan;
import silvadev.com.br.mylibrary.domain.bookLoanItem.BookLoanItem;
import silvadev.com.br.mylibrary.dto.bookLoan.BookLoanIdDTO;
import silvadev.com.br.mylibrary.dto.bookLoan.BookLoanRequestDTO;
import silvadev.com.br.mylibrary.repositories.BookLoanItemRepository;
import silvadev.com.br.mylibrary.repositories.BookLoanRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookLoanService {
    private final BookLoanRepository bookLoanRepository;
    private final BookLoanItemRepository bookLoanItemRepository;

    public BookLoan getBookLoan(String id) {
        return this.bookLoanRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Loan not found with ID:" + id));
    }

    public List<BookLoan> getBookLoan() {
        return this.bookLoanRepository.findAll();
    }

    public BookLoanIdDTO createBookLoan(BookLoanRequestDTO dto) {
        BookLoan bookLoan = new BookLoan();
        bookLoan.setBookReader(dto.bookReader());
        bookLoan.setBookLoanItems(dto.bookLoanItems());
        bookLoan.setLoanDate(dto.loanDate());
        bookLoan.setDevolutionDate(bookLoan.getLoanDate().plusDays(14));
        bookLoan.setIsActive(true);
        bookLoan.setCreatedAt(LocalDateTime.now());

        this.bookLoanRepository.save(bookLoan);

        for (BookLoanItem bookLoanItem : bookLoan.getBookLoanItems()) {
            bookLoanItem.setBookLoan(bookLoan);
            bookLoanItem.setIsActive(true);
            bookLoanItem.setCreatedAt(LocalDateTime.now());
            this.bookLoanItemRepository.save(bookLoanItem);
        }

        return new BookLoanIdDTO(bookLoan.getId());
    }
}
