package org.me.jpa.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity(name = "transfer")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne
    @JoinColumn(name = "account_from")
    Account from;

    @OneToOne
    @JoinColumn(name = "account_to")
    Account to;
    @Column(name = "transfer_date")
    @Temporal(TemporalType.TIMESTAMP)
    Timestamp transferDate;

    public Transfer() {}

    public Transfer(Account from, Account to, Timestamp transferDate) {
        this.from = from;
        this.to = to;
        this.transferDate = transferDate;
    }

    public Integer getId() {
        return id;
    }

    public Account getFrom() {
        return from;
    }

    public Account getTo() {
        return to;
    }

    public Timestamp getTransferDate() {
        return transferDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transfer transfer = (Transfer) o;

        return Objects.equals(id, transfer.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
