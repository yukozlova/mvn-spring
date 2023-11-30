package org.me.jdbc.controller;

import org.me.jdbc.model.Account;
import org.me.jdbc.repository.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable int id, UriComponentsBuilder ucb) {
        Optional<Account> account = accountRepository.findById(id);
        return ResponseEntity.of(account);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Account account, UriComponentsBuilder ucb) {
        Account saved = accountRepository.save(account);
        URI location = ucb.path("/accounts/{id}")
                .buildAndExpand(saved.id())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
