package silvadev.com.br.mylibrary.dto.bookLoan;

import silvadev.com.br.mylibrary.domain.bookCopy.BookCopy;
import silvadev.com.br.mylibrary.domain.bookLoanItem.BookLoanItem;
import silvadev.com.br.mylibrary.domain.bookReader.BookReader;

import java.time.LocalDateTime;
import java.util.List;

public record BookLoanRequestDTO(LocalDateTime loanDate, BookReader bookReader, List<BookLoanItem> bookLoanItems) {
}
