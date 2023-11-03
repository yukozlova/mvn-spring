package org.me.mvnspring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {
    private CashCardRepository cashCardRepository;

    public CashCardController(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }
    @GetMapping("/{id}")
    ResponseEntity<String> findById(@PathVariable long id, UriComponentsBuilder ucb) {
        URI location = ucb.path("/cashcards/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.ok("somestring");
    }

    @PostMapping
    ResponseEntity<Void> save(@RequestBody CashCard card, UriComponentsBuilder ucb) {
        CashCard saved = cashCardRepository.save(card);
        URI location = ucb.path("/cashcards/{id}")
                .buildAndExpand(saved.id())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
