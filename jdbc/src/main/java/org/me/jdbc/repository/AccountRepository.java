package org.me.jdbc.repository;

import org.me.jdbc.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
