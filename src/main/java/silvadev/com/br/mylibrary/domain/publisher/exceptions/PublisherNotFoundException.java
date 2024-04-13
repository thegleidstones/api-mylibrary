package silvadev.com.br.mylibrary.domain.publisher.exceptions;

public class PublisherNotFoundException extends RuntimeException {
    public PublisherNotFoundException(String message) {
        super(message);
    }
}
