package silvadev.com.br.mylibrary.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import silvadev.com.br.mylibrary.domain.publisher.Publisher;
import silvadev.com.br.mylibrary.domain.publisher.exceptions.PublisherNotFoundException;
import silvadev.com.br.mylibrary.dto.publisher.PublisherIdDTO;
import silvadev.com.br.mylibrary.repositories.PublisherRepository;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public Publisher getPublisher(String publisherId) {
        return this.publisherRepository.findById(publisherId).orElseThrow(() -> new PublisherNotFoundException("Publisher not found with ID: " + publisherId));
    }
}
