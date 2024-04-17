package silvadev.com.br.mylibrary.domain.bookCopy.exceptions;

public class BookCopyNotFoundException extends RuntimeException {
    public BookCopyNotFoundException(String message) {
        super(message);
    }
}
