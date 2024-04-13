package silvadev.com.br.mylibrary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import silvadev.com.br.mylibrary.domain.publisher.Publisher;
import silvadev.com.br.mylibrary.services.PublisherService;

@RestController
@RequestMapping("/publishers")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisher(@PathVariable String id) {
        Publisher publisher = this.publisherService.getPublisher(id);
        return ResponseEntity.ok(publisher);
    }
}
