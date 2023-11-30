package org.me.jpa.repository;

import org.me.jpa.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
