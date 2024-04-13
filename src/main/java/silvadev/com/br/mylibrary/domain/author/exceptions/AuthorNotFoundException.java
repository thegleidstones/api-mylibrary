package silvadev.com.br.mylibrary.domain.author.exceptions;

public class AuthorNotFoundException extends  RuntimeException {
    public AuthorNotFoundException(String message) {
        super(message);
    }
}
