package org.me.jdbc.model;

import org.springframework.data.annotation.Id;

public record CashCard(@Id Long id, double amount) {
}