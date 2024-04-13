package silvadev.com.br.mylibrary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import silvadev.com.br.mylibrary.domain.publisher.Publisher;
import silvadev.com.br.mylibrary.dto.publisher.PublisherIdDTO;
import silvadev.com.br.mylibrary.dto.publisher.PublisherRequestDTO;
import silvadev.com.br.mylibrary.services.PublisherService;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Publisher>> getPublisher() {
        List<Publisher> publisherList = this.publisherService.getPublisher();
        return ResponseEntity.ok(publisherList);
    }

    @PostMapping
    public ResponseEntity<PublisherIdDTO> createPublisher(@RequestBody PublisherRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        PublisherIdDTO publisherId = this.publisherService.createPublisher(body);

        var uri = uriComponentsBuilder.path("/publishers/{id}").buildAndExpand(publisherId.publisherId()).toUri();

        return ResponseEntity.created(uri).body(publisherId);
    }
}
