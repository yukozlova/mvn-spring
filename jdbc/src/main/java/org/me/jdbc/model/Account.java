package org.me.jdbc.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public record Account(@Id Integer id, BigDecimal amount) {
}
