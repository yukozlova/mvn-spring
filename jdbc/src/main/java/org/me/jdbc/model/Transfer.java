package org.me.jdbc.model;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

public record Transfer(@Id Integer id, Account accountFrom, Account accountTo, Timestamp transferDate) {
}
