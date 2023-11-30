package org.me.jpa;

import org.junit.jupiter.api.Test;
import org.me.jpa.model.Account;
import org.me.jpa.model.Transfer;
import org.me.jpa.repository.AccountRepository;
import org.me.jpa.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class RepoTests {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransferRepository transferRepository;

    @Test
    void testAccountRepo() {
        Account account = new Account(BigDecimal.valueOf(370002345, 4));
        Account saved = accountRepository.save(account);
        Account retrieved = accountRepository.findById(saved.getId()).orElse(null);
        assertThat(retrieved).isNotNull();
        assertThat(retrieved).isEqualTo(saved);
    }

    @Test
    void testTransferRepo() {
        Account from = accountRepository.findById(1).get();
        Account to = accountRepository.findById(2).get();
        Transfer transfer = new Transfer(from, to, Timestamp.from(Instant.now()));
        Transfer saved = transferRepository.save(transfer);
        Transfer retrieved = transferRepository.findById(saved.getId()).orElse(null);
        assertThat(retrieved).isNotNull();
        assertThat(retrieved).isEqualTo(saved);
    }

    @Test
    void contextLoad() {

    }

}
