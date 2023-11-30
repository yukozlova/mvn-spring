package org.me.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "account")
public class Account {
    public Account() {}

    public Account(BigDecimal amount) {
        this.amount = amount;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    BigDecimal amount;

    public Integer getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
