package silvadev.com.br.mylibrary.domain.bookReader.exceptions;

public class BookReaderNotFoundException extends RuntimeException{
    public BookReaderNotFoundException(String message) {
        super(message);
    }
}
