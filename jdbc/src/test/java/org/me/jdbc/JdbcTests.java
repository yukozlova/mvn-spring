package org.me.jdbc;

import org.junit.jupiter.api.Test;
import org.me.jdbc.model.CashCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JdbcTests {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void contextLoads() {

    }

    @Test
    void shouldReturnCashCard() {
        ResponseEntity<String> resp = restTemplate.getForEntity("/cashcards/99", String.class);
        assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resp.getBody()).isEqualTo("somestring");
    }

    @Test
    void shouldSaveCashCard() {
        ResponseEntity<Void> resp = restTemplate.postForEntity("/cashcards", new CashCard(null, 100.10),
                Void.class);
        assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}
