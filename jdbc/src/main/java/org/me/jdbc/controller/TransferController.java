package org.me.jdbc.controller;

import org.me.jdbc.model.Transfer;
import org.me.jdbc.repository.TransferRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/transfers")
public class TransferController {
    private TransferRepository transferRepository;

    public TransferController(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transfer> findById(@PathVariable int id) {
        Optional<Transfer> transfer = transferRepository.findById(id);
        return ResponseEntity.of(transfer);
    }

    @PostMapping
    public ResponseEntity<Void> save(Transfer transfer, UriComponentsBuilder ucb) {
        Transfer saved = transferRepository.save(transfer);
        URI location = ucb.path("/transfers/{id}")
                .buildAndExpand(saved.id())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
